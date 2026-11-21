package application;
import java.util.concurrent.ThreadLocalRandom;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Die extends StackPane {
    private ImageView imageView = new ImageView();
    private Rectangle border;
    private boolean locked = false;
    private boolean selected = false;
    private int value;
    private int diceID;

    public Die(int diceID) {
    	this.diceID = diceID;
        border = new Rectangle(LayoutConstants.DIE_WIDTH, LayoutConstants.DIE_HEIGHT);
        setAlignment(Pos.CENTER);
        updateBorder();
        
        rollDie(diceID-1);
        imageView.setFitWidth(LayoutConstants.DIE_WIDTH);
        imageView.setFitHeight(LayoutConstants.DIE_HEIGHT);
        
        getChildren().addAll(border, imageView);
        
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	if(GamePanel.canSelect == true) {
            		toggleSelection();
            		GamePanel.playerID[GamePanel.currentPlayer].selectedDice[diceID-1] = selected;
            	}
            }
        });
    }
    
    public void rollDie(int diceID) {
        final int MIN = 1; // Minimum die value
        final int MAX = 6; // Maximum die value
        int randomDieValue = ThreadLocalRandom.current().nextInt(MIN, MAX + 1); // Generate random die value
        if(selected == true) {
        	toggleLock();
        }
        if(locked == false) {
        	System.out.println(randomDieValue);
        	GamePanel.playerID[GamePanel.currentPlayer].dice[diceID] = randomDieValue;
        	String imageFileName = "/images/Dice" + randomDieValue + ".png"; // Construct file name for die face image
        	Image image = new Image(getClass().getResource(imageFileName).toExternalForm()); // Load image
        	imageView.setImage(image); // Set image to the image view
        }
    }
    
    public void rollDie(int diceID, Stage primaryStage) {
        final int MIN = 1; // Minimum die value
        final int MAX = 6; // Maximum die value
        int randomDieValue = ThreadLocalRandom.current().nextInt(MIN, MAX + 1); // Generate random die value
        if(selected == true) {
        	toggleLock();
        }
        if(locked == false) {
        	System.out.println(randomDieValue);
        	randomDieValue = GamePanel.playerID[GamePanel.currentPlayer].dice[diceID];
        	String imageFileName = "/images/Dice" + randomDieValue + ".png"; // Construct file name for die face image
        	Image image = new Image(getClass().getResource(imageFileName).toExternalForm()); // Load image
        	imageView.setImage(image); // Set image to the image view
        	primaryStage.show();
        }
    }
    
    public void toggleLock() {
    	toggleSelection();
        locked = !locked;
        updateBorder();
    }
    
    public void toggleSelection() {
    	if(locked == false) {
        selected = !selected;
        GamePanel.playerID[GamePanel.currentPlayer].selectedDice[diceID-1] = selected;
        updateBorder();
        
    	}
    }
    
    public boolean isLocked() {
        return locked;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getValue() {
        return value;
    }
    
    private void updateBorder() {
        border.setStrokeWidth(5); // Set border stroke width
        if (locked) {
            border.setStroke(Color.GREEN); // Locked dice border color
        } else if (selected) {
            border.setStroke(Color.YELLOW); // Selected dice border color
        } else {
            border.setStroke(Color.RED); // Unselected dice border color
        }
    }

	public void setLocked(boolean b) {
		locked = b;
		GamePanel.playerID[GamePanel.currentPlayer].selectedDice[diceID-1] = selected;
		updateBorder();
	}
	public void setSelect(boolean b) {
		selected = b;
		GamePanel.playerID[GamePanel.currentPlayer].selectedDice[diceID-1] = selected;
		updateBorder();
	}
}
