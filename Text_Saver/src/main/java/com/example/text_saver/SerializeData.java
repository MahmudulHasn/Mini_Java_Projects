// Package declaration for the Java class
package com.example.text_saver;

// Import statements to bring in necessary classes
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

// Class declaration for the data serialization class
public class SerializeData implements Serializable {

    // Serializable field to store text data
    public String textData;

    // Constant for the file name used for serialization/deserialization
    public final static String fileName = "dataSerializable";

    // Method to serialize data (write object to a file)
    public void serializeData() throws IOException {
        // Create a FileOutputStream to write data to a file with the specified fileName
        FileOutputStream file = new FileOutputStream(fileName);

        // Create an ObjectOutputStream to write Java objects to the file
        ObjectOutputStream out = new ObjectOutputStream(file);

        // Serialize (write) the current object (this) to the file
        out.writeObject(this);

        // Close the ObjectOutputStream and FileOutputStream
        out.close();
        file.close();

        // Print a message indicating that the object has been serialized
        System.out.println("Object has been serialized");
    }

    // Method to deserialize data (read object from a file)
    public void deSerializeData() throws IOException, ClassNotFoundException {
        // Create a FileInputStream to read data from the file with the specified fileName
        FileInputStream file = new FileInputStream(fileName);

        // Create an ObjectInputStream to read Java objects from the file
        ObjectInputStream in = new ObjectInputStream(file);

        // Deserialize (read) the object from the file and assign its textData to the current object's textData
        this.textData = ((SerializeData) in.readObject()).textData;

        // Close the ObjectInputStream and FileInputStream
        in.close();
        file.close();
    }
}

