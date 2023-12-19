// Package declaration for the Java class
package com.example.text_saver;

// Import statements to bring in necessary JavaFX classes and exceptions
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

// Class declaration for the controller class associated with the FXML layout
public class AppSceneController implements Initializable {

    // FXML annotations to inject UI components defined in the FXML file
    @FXML
    Button saveButton, clearButton;
    @FXML
    TextArea writeText;

    // Initialization method called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create an instance of the SerializeData class
        SerializeData data = new SerializeData();

        try {
            // Attempt to deserialize data from a file using the SerializeData class
            data.deSerializeData();
        } catch (Exception e) {
            // If an exception occurs during deserialization, catch it (ignoring for simplicity)
        }

        // Set the text of the TextArea (writeText) to the deserialized textData
        writeText.setText(data.textData);
    }

    // Event handler method for the "Clear" button click
    public void onClearButtonClicked() {
        // Clear the text content of the TextArea (writeText)
        writeText.clear();
    }

    // Event handler method for the "Save" button click
    public void onSaveButtonClicked() throws IOException {
        // Create an instance of the SerializeData class
        SerializeData data = new SerializeData();

        // Set the textData property of the SerializeData instance to the text content of the TextArea
        data.textData = writeText.getText();

        // Serialize the data (write it to a file) using the SerializeData class
        data.serializeData();
    }
}

