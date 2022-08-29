package com.github.lunarconcerto.umaaudiogui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class UmaAudioController {

    public File outputFile ;

    @FXML
    public TextField outputPath;

    @FXML
    public Button showFileSelectorButton;

    @FXML
    public Button startOutputButton;

    @FXML
    public Button loadAssetListButton;

    @FXML
    public ListView<AssetInfo> assetList;

    @FXML
    public ListView<AnchorPane> cndList;

    @FXML
    public ProgressBar progressBar;

    @FXML
    public void onloadAssetListButtonAction(ActionEvent actionEvent) {
        assetList.getItems().clear();

        UmaAssetLoader.loadAssetInfo()
                .stream()
                .filter(info ->
                         cndList.getItems().stream()
                                 .noneMatch(anchorPane -> anchorPane instanceof ConditionPane) ||
                         cndList.getItems().stream()
                                 .filter(item -> item instanceof ConditionPane)
                                 .allMatch(item -> info.getN().contains(((ConditionPane) item).getText())))
                .forEach(info -> assetList.getItems().add(info));
    }

    @FXML
    public void onFileSelectorButtonAction(ActionEvent actionEvent) {
        outputFile = createNewDirectoryChooser();
        outputPath.setText(outputFile.getPath());
    }

    File createNewDirectoryChooser(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("选择一个文件夹");
        return chooser.showDialog(new Stage());
    }

    @FXML
    public void onOutputStart(ActionEvent actionEvent) {
        if (!isOutputFileExists()){
            alertDialog("未选择输出路径!").show();
            return;
        }

        if (assetList.getItems().isEmpty()){
            alertDialog("未读取资源！").show();
            return;
        }

        progressBar.setProgress(0);
        Thread runner = new Thread(() -> {
            float index = 0.0f , length = assetList.getItems().size();
            for (AssetInfo item : assetList.getItems()) {
                resolveAsset(item);

                index++;
                float finalIndex = index;
                Platform.runLater(() -> progressBar.setProgress(finalIndex / length));
            }

            System.out.println("All done.");
        });

        runner.start();
    }

    void resolveAsset(AssetInfo info){
        String targetPath = UmaAssetLoader.UMA_ASSET_FOLDER + "/dat/" + info.getHStart() + "/" + info.getH();
        File file = new File(targetPath);
        if (!file.exists()){
            System.out.println(targetPath + " || is not exists.");
            return;
        }

        try {
            String output = outputFile.getPath() + "/" + info.getN();
            File file2 = new File(output);
            if (file2.exists()) {
                System.out.println(output + " || is already exists.");
                return;
            }

            Path path = Files.copy(Path.of(targetPath), Path.of(output));

            System.out.println("Output file -> " + path.getFileName());
        }catch (IOException ignored) {}
    }

    Dialog<?> alertDialog(String info){
        return new Alert(Alert.AlertType.WARNING,
                info,
                ButtonType.OK);
    }

    boolean isOutputFileExists(){
        return outputFile!=null && outputFile.exists();
    }

    static class ConditionAppenderButton extends Button {

        public ConditionAppenderButton() {
            super("增加条件...");

            init();
        }

        void init(){
            this.setOnAction(this::onAction);
        }

        void onAction(ActionEvent event){
            UmaAudioGUI.controller.cndList.getItems().add(new ConditionPane());
        }

    }

    static class ConditionPane extends AnchorPane {

        TextField condition ;

        public ConditionPane() {
            this.getChildren().add(new Label("包含:"));
            condition = new TextField();
            condition.setLayoutX(40);
            this.getChildren().add(condition);

            Button button = new Button("删除");
            button.setLayoutX(180);
            button.setOnAction(event -> {
                UmaAudioGUI.controller.cndList.getItems().remove(this);
            });
            this.getChildren().add(button);
        }

        public String getText() {
            return condition.getText();
        }

    }

}