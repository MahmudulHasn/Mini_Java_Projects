module com.example.mario_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mario_game to javafx.fxml;
    exports com.example.mario_game;
}