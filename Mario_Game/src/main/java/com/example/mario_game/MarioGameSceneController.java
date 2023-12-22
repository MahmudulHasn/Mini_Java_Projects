package com.example.mario_game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * MarioGameSceneController class controls the behavior of the Mario game scene.
 * It implements the Initializable interface for JavaFX initialization.
 */
public class MarioGameSceneController implements Initializable {
    private int movementSpeed = 20;
    int screenHeight = 540;
    int screenWidth = 800;

    @FXML
    ImageView mushroomImage1, mushroomImage2, mushroomImage3, playerImageView;
    @FXML
    Rectangle rect1, rect2, rect3, playerRect;
    @FXML
    Button upButton, downButton, leftButton, rightButton;
    @FXML
    Pane onGameFinishedPane;

    /**
     * Initializes the controller, setting up initial positions of elements.
     * @param url The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object, or null if none.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up visibility and disable state of onGameFinishedPane
        onGameFinishedPane.setVisible(false);
        onGameFinishedPane.setDisable(true);

        // Set initial positions of rectangles to match mushroom images
        rect1.setLayoutX(mushroomImage1.getLayoutX());
        rect1.setLayoutY(mushroomImage1.getLayoutY());

        rect2.setLayoutX(mushroomImage2.getLayoutX());
        rect2.setLayoutY(mushroomImage2.getLayoutY());

        rect3.setLayoutX(mushroomImage3.getLayoutX());
        rect3.setLayoutY(mushroomImage3.getLayoutY());

        playerRect.setLayoutX(playerImageView.getLayoutX());
        playerRect.setLayoutY(playerImageView.getLayoutY());

    }

    public void onUpButtonClicked(){
        // Set player image and update player position
        playerImageView.setImage(new Image(getClass().getResourceAsStream("/images/mario_back.png")));
        playerImageView.setLayoutY(playerImageView.getLayoutY() - movementSpeed);

        // Wrap player around when reaching the top edge
        playerRect.setLayoutY(playerRect.getLayoutY() - movementSpeed);

        if (playerImageView.getLayoutY() < - 0) {
            playerImageView.setLayoutY(screenHeight);
            playerRect.setLayoutY(screenHeight);
        }
        // Check for collisions with mushrooms
        isCollideWithMushroom();
    }
    public void onDownButtonClicked(){
        // Set player image and update player position
        playerImageView.setImage(new Image(getClass().getResourceAsStream("/images/mario_front.png")));
        playerImageView.setLayoutY(playerImageView.getLayoutY() + movementSpeed);

        // Wrap player around when reaching the top edge
        playerRect.setLayoutY(playerRect.getLayoutY() + movementSpeed);

        if (playerImageView.getLayoutY() > screenHeight) {
            playerImageView.setLayoutY(0);
            playerRect.setLayoutY(0);
        }
        // Check for collisions with mushrooms
        isCollideWithMushroom();
    }
    public void onLeftButtonClicked(){
        // Set player image and update player position
        playerImageView.setImage(new Image(getClass().getResourceAsStream("/images/mario_left.png")));
        playerImageView.setLayoutX(playerImageView.getLayoutX() - movementSpeed);

        // Wrap player around when reaching the top edge
        playerRect.setLayoutX(playerRect.getLayoutX() - movementSpeed);

        if (playerImageView.getLayoutX() < - 0) {
            playerImageView.setLayoutX(screenWidth);
            playerRect.setLayoutX(screenWidth);
        }
        // Check for collisions with mushrooms
        isCollideWithMushroom();
    }
    public void onRightButtonClicked(){
        // Set player image and update player position
        playerImageView.setImage(new Image(getClass().getResourceAsStream("/images/mario_right.png")));
        playerImageView.setLayoutX(playerImageView.getLayoutX() + movementSpeed);

        // Wrap player around when reaching the top edge
        playerRect.setLayoutX(playerRect.getLayoutX() + movementSpeed);

        if (playerImageView.getLayoutX() > screenWidth) {
            playerImageView.setLayoutX(0);
            playerRect.setLayoutX(0);
        }
        // Check for collisions with mushrooms
        isCollideWithMushroom();
    }

    /**
     * Checks if the player collides with any of the mushrooms and updates visibility accordingly.
     */
    public void isCollideWithMushroom() {
        // Get bounding boxes for player and mushrooms
        Bounds playerBounds = playerRect.getBoundsInParent();
        Bounds rect1Bounds = rect1.getBoundsInParent();
        Bounds rect2Bounds = rect2.getBoundsInParent();
        Bounds rect3Bounds = rect3.getBoundsInParent();

        // Update mushroom visibility if there's a collision
        if (playerBounds.intersects(rect1Bounds)) {
            mushroomImage1.setVisible(false);
        }
        if (playerBounds.intersects(rect2Bounds)) {
            mushroomImage2.setVisible(false);
        }
        if (playerBounds.intersects(rect3Bounds)) {
            mushroomImage3.setVisible(false);
        }
        // Check if all mushrooms are consumed and trigger game finished event
        onGameFinished();
    }

    /**
     * Handles the game finished event by disabling player controls and displaying the game finished pane.
     */
    public void onGameFinished(){
        // Check if all mushrooms are consumed
        if (!(mushroomImage1.isVisible() || mushroomImage2.isVisible()  || mushroomImage3.isVisible())){
            upButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);
            rightButton.setDisable(true);

            // Display the game finished pane
            onGameFinishedPane.setVisible(true);
            onGameFinishedPane.setDisable(false);
        }
    }

    /**
     * Handles the "Quit" button click event by exiting the application.
     */
    public void onQuitButtonClicked(){
        Platform.exit();
    }

}
