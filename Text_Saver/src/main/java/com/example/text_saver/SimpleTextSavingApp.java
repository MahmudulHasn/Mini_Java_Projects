// Package declaration for the Java class
package com.example.text_saver;

// Import statements to bring in necessary JavaFX classes and exceptions
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;

// Class declaration for the main application class, extending the JavaFX Application class
public class SimpleTextSavingApp extends Application {

    // The start method is the entry point for JavaFX applications
    @Override
    public void start(Stage stage) throws IOException {
        // Create a FXMLLoader instance to load the FXML file that defines the UI layout
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleTextSavingApp.class.getResource("appScene.fxml"));

        // Load the FXML file, creating the UI layout, and set it as the content of the scene
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Set the title of the main application window
        stage.setTitle("Text Saver");

        // Set the scene for the main application window
        stage.setScene(scene);

        // Make the main application window visible
        stage.show();
    }

    // The main method is the entry point for non-JavaFX applications
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}

