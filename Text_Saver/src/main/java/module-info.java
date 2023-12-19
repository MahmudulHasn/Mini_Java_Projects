module com.example.text_saver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.text_saver to javafx.fxml;
    exports com.example.text_saver;
}