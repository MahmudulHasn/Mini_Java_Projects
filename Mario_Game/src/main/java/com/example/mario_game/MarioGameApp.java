
/**
 * Mario Game Concepts:
 *
 ●   Mario can be moved left, up, down, right using 4 buttons.
 ●   While moving left, up, down, right the image of mario will be as changed.
 ●   If Mario comes in contact with a mushroom. The mushroom will go out of the screen.
 ●   If Mario moves to the extreme left and gets out of the screen, Mario will again re-enter the screen from the
right side.
 */

package com.example.mario_game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * MarioGameApp is the main class that launches the Mario game application.
 * It extends the Application class provided by JavaFX.
 */
public class MarioGameApp extends Application {

    /**
     * The entry point of the application. Starts the JavaFX application by loading the FXML file,
     * setting up the main stage, and displaying it.
     *
     * @param stage The primary stage for the application.
     * @throws Exception If there is an issue during application startup.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file representing the game scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MarioGameScene.fxml"));
        Parent root = loader.load();

        // Set up the main stage
        stage.setTitle("Mario Game");
        stage.setScene(new Scene(root, 800, 540));

        // Display the main stage
        stage.show();
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args Command-line arguments passed to the application (not used in this case).
     */
    public static void main(String[] args) {
        launch(args);
    }
}

