package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

//Class representing the pane containing game control buttons
public class ButtonPanes extends StackPane {
 private Button rollButton; // Button for rolling dice
 private Button playButton; // Button for starting the game
 private Button scoreButton; // Button for scoring points
 private Button endTurnButton; // Button for ending the current turn

 // Constructor for ButtonPanes
 public ButtonPanes() {    
     setMinWidth(LayoutConstants.APP_WIDTH); // Set minimum width
     setMinHeight(LayoutConstants.BUTTON_PANE_HEIGHT); // Set minimum height
     setTranslateX(LayoutConstants.APP_WIDTH / 2); // Set translation X
     
     // Calculate translation Y to center the pane vertically
     setTranslateY(LayoutConstants.HEADER_PANE_HEIGHT + 
                   LayoutConstants.SCORE_PANE_HEIGHT +
                   LayoutConstants.MESSAGE_PANE_HEIGHT + 
                   LayoutConstants.DICE_PANE_HEIGHT +
                   (LayoutConstants.BUTTON_PANE_HEIGHT / 2));
     
     final int BUTTON_WIDTH = 100; // Width of the buttons
     final int BUTTON_HEIGHT = 50; // Height of the buttons
     final int BUTTON_MARGIN = 50; // Margin between buttons
     
     // Create and configure roll button
     rollButton = new Button("Roll");
     rollButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
     rollButton.setTranslateX((BUTTON_WIDTH + BUTTON_MARGIN) * -1);
     
     // Create and configure play button
     playButton = new Button("Play");
     playButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
     playButton.setTranslateX((BUTTON_WIDTH + BUTTON_MARGIN) * -0.05);
 
     // Create and configure score button
     scoreButton = new Button("Score");
     scoreButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
     
     // Create and configure end turn button
     endTurnButton = new Button("End Turn");
     endTurnButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
     endTurnButton.setTranslateX((BUTTON_WIDTH + BUTTON_MARGIN));
     
     // Add all buttons to the pane
     getChildren().addAll(rollButton, playButton, scoreButton, endTurnButton);
 }

 // Method to set action handler for the roll button
	public void setRollButtonOnAction(EventHandler<ActionEvent> onButtonAction) {
 	rollButton.setOnAction(onButtonAction);
 }
 
 // Method to set action handler for the play button
 public void setPlayButtonOnAction(EventHandler<ActionEvent> onButtonAction) {
 	playButton.setOnAction(onButtonAction);
 }
 
 // Method to set action handler for the score button
 public void setScoreButtonOnAction(EventHandler<ActionEvent> onButtonAction) {
 	scoreButton.setOnAction(onButtonAction);
 }
 
 // Method to set action handler for the end turn button
 public void setEndTurnButtonOnAction(EventHandler<ActionEvent> onButtonAction) {
 	endTurnButton.setOnAction(onButtonAction);
 }

 // Method to set the visibility of the roll button
 public void setRollButtonVisible(boolean isVisible) {
 	rollButton.setVisible(isVisible);
 }
 
 // Method to set the visibility of the play button
 public void setPlayButtonVisible(boolean isVisible) {
 	playButton.setVisible(isVisible);
 }
 
 // Method to set the visibility of the score button
 public void setScoreButtonVisible(boolean isVisible) {
 	scoreButton.setVisible(isVisible);
 }
 
 // Method to set the visibility of the end turn button
 public void setEndTurnButtonVisible(boolean isVisible) {
 	endTurnButton.setVisible(isVisible);
 }
 
 // Method to set the disabled state of the end turn button
 public void setEndTurnButtonDisable(boolean isDisabled) {
 	endTurnButton.setDisable(isDisabled);
 }
}
  