package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

//Class representing the scoreboard pane of the application
public class ScoreBoard extends StackPane {

 private static Label player1ScoreLabel; // Label for player 1's score
 private static Label aiScoreLabel; // Label for AI's score
 private static Label ai2ScoreLabel; // Label for AI's score
 private static Label ai3ScoreLabel; // Label for AI's score
 private static Label runningsScore; // Label for running score

 
 // Constructor for ScoreBoard
 public ScoreBoard() {
     setMinWidth(LayoutConstants.APP_WIDTH); // Set minimum width
     setMinHeight(LayoutConstants.SCORE_PANE_HEIGHT); // Set minimum height
     setTranslateX(LayoutConstants.APP_WIDTH / 2); // Set translation X
     setTranslateY(LayoutConstants.HEADER_PANE_HEIGHT + (LayoutConstants.SCORE_PANE_HEIGHT / 2)); // Set translation Y

     // Labels for player 1 and AI
     Label player1Label = new Label(GamePanel.player1.name + ": "); // Create label for player 1
     player1Label.setMinWidth(100); // Set minimum width
     player1Label.setMinHeight(30); // Set minimum height
     player1Label.setAlignment(Pos.CENTER); // Set alignment to center
     player1Label.setFont(Font.font(16)); // Set font size
     player1Label.setTranslateX(-200); // Set translation X
     player1Label.setTranslateY(-15); // Set translation Y

     Label aiLabel = new Label(GamePanel.cp1.name + "AI: "); // Create label for AI
     aiLabel.setMinWidth(100); // Set minimum width
     aiLabel.setMinHeight(30); // Set minimum height
     aiLabel.setAlignment(Pos.CENTER); // Set alignment to center
     aiLabel.setFont(Font.font(16)); // Set font size
     aiLabel.setTranslateX(-200); // Set translation X
     aiLabel.setTranslateY(15); // Set translation Y

     // Labels for player 1's score and AI's score
     player1ScoreLabel = new Label("0"); // Create label for player 1's score
     player1ScoreLabel.setMinWidth(100); // Set minimum width
     player1ScoreLabel.setMinHeight(30); // Set minimum height
     player1ScoreLabel.setAlignment(Pos.CENTER); // Set alignment to center
     player1ScoreLabel.setFont(Font.font(16)); // Set font size
     player1ScoreLabel.setTranslateX(-125); // Set translation X
     player1ScoreLabel.setTranslateY(-15); // Set translation Y

     aiScoreLabel = new Label("0"); // Create label for AI's score
     aiScoreLabel.setMinWidth(100); // Set minimum width
     aiScoreLabel.setMinHeight(30); // Set minimum height
     aiScoreLabel.setAlignment(Pos.CENTER); // Set alignment to center
     aiScoreLabel.setFont(Font.font(16)); // Set font size
     aiScoreLabel.setTranslateX(-125); // Set translation X
     aiScoreLabel.setTranslateY(15); // Set translation Y

     Label ai2Label = new Label(GamePanel.cp2.name + "AI: "); // Create label for AI
     ai2Label.setMinWidth(100); // Set minimum width
     ai2Label.setMinHeight(30); // Set minimum height
     ai2Label.setAlignment(Pos.CENTER); // Set alignment to center
     ai2Label.setFont(Font.font(16)); // Set font size
     ai2Label.setTranslateX(-200); // Set translation X
     ai2Label.setTranslateY(45); // Set translation Y
     
     ai2ScoreLabel = new Label("0"); // Create label for AI's score
     ai2ScoreLabel.setMinWidth(100); // Set minimum width
     ai2ScoreLabel.setMinHeight(30); // Set minimum height
     ai2ScoreLabel.setAlignment(Pos.CENTER); // Set alignment to center
     ai2ScoreLabel.setFont(Font.font(16)); // Set font size
     ai2ScoreLabel.setTranslateX(-125); // Set translation X
     ai2ScoreLabel.setTranslateY(45); // Set translation Y = new Label("0");
     
     Label ai3Label = new Label(GamePanel.cp3.name + "AI: "); // Create label for AI
     ai3Label.setMinWidth(100); // Set minimum width
     ai3Label.setMinHeight(30); // Set minimum height
     ai3Label.setAlignment(Pos.CENTER); // Set alignment to center
     ai3Label.setFont(Font.font(16)); // Set font size
     ai3Label.setTranslateX(-200); // Set translation X
     ai3Label.setTranslateY(75); // Set translation Y
     
     ai3ScoreLabel = new Label("0"); // Create label for AI's score
     ai3ScoreLabel.setMinWidth(100); // Set minimum width
     ai3ScoreLabel.setMinHeight(30); // Set minimum height
     ai3ScoreLabel.setAlignment(Pos.CENTER); // Set alignment to center
     ai3ScoreLabel.setFont(Font.font(16)); // Set font size
     ai3ScoreLabel.setTranslateX(-125); // Set translation X
     ai3ScoreLabel.setTranslateY(75); // Set translation Y = new Label("0");
 
     Label runningsScoreTitle = new Label("running score: "); // Create label for turn score
     runningsScoreTitle.setMinWidth(150); // Set minimum width
     runningsScoreTitle.setMinHeight(30); // Set minimum height
     runningsScoreTitle.setAlignment(Pos.CENTER); // Set alignment to center
     runningsScoreTitle.setFont(Font.font(20)); // Set font size
     runningsScoreTitle.setTranslateX(-30); // Set translation X
     runningsScoreTitle.setTranslateY(130); // Set translation Y
     
     runningsScore = new Label(""); // Create label for turn score
     runningsScore.setMinWidth(150); // Set minimum width
     runningsScore.setMinHeight(30); // Set minimum height
     runningsScore.setAlignment(Pos.CENTER); // Set alignment to center
     runningsScore.setFont(Font.font(20)); // Set font size
     runningsScore.setTranslateX(60); // Set translation X
     runningsScore.setTranslateY(130); // Set translation Y
     
     // Add labels to the scoreboard pane
     getChildren().addAll(player1Label, aiLabel, ai2Label, ai3Label, runningsScoreTitle, runningsScore, player1ScoreLabel, aiScoreLabel, ai2ScoreLabel, ai3ScoreLabel);
 }
//Method to update running score
public static void updateRunningScore(int score) {
	runningsScore.setText(Integer.toString(score)); // Set player 1's score label
}
 
 
 // Method to update player 1's score
 public static void updatePlayer1Score(int score) {
    player1ScoreLabel.setText(Integer.toString(score)); // Set player 1's score label
 }

 // Method to update AI 1 score
 public static void updateAIScore(int score) {
      aiScoreLabel.setText(Integer.toString(score)); // Set AI's score label
 }
 
//Method to update AI 2 score
public static void updateAI2Score(int score) {
    ai2ScoreLabel.setText(Integer.toString(score)); // Set AI's score label
}

//Method to update AI 3 score
public static void updateAI3Score(int score) {
   ai3ScoreLabel.setText(Integer.toString(score)); // Set AI's score label
}
}
