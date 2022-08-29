module com.github.lunarconcerto.umaaudiogui {
    requires javafx.controls;
    requires javafx.fxml;
    requires nutz;
    requires java.sql;


    opens com.github.lunarconcerto.umaaudiogui to javafx.fxml;
    exports com.github.lunarconcerto.umaaudiogui;
}