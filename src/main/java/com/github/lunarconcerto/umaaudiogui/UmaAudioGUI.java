package com.github.lunarconcerto.umaaudiogui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UmaAudioGUI extends Application {

    public static UmaAudioController controller ;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UmaAudioGUI.class.getResource("uma_audio_gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("UmaAudioGUI");
        stage.setScene(scene);
        stage.show();

        initController(fxmlLoader);
    }

    static void initController(FXMLLoader fxmlLoader){
        controller = fxmlLoader.getController();

        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(new UmaAudioController.ConditionAppenderButton());
        controller.cndList.getItems().add(pane);
    }

}