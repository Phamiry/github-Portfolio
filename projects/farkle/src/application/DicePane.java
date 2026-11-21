package application;

import java.util.Arrays;
import java.util.List;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DicePane extends StackPane {
    private static Die die1 = new Die(1);
    private static Die die2 = new Die(2);
    private static Die die3 = new Die(3);
    private static Die die4 = new Die(4);
    private static Die die5 = new Die(5);
    private static Die die6 = new Die(6);
    
    public static List<Die> allDice = Arrays.asList(die1, die2, die3, die4, die5, die6);
    
    public List<Die> getAllDice() {
		return allDice;
    	
    }
    
    public DicePane() {
        setMinWidth(LayoutConstants.APP_WIDTH);
        setMinHeight(LayoutConstants.DICE_PANE_HEIGHT);
        setTranslateX(LayoutConstants.APP_WIDTH / 2);
        setTranslateY(LayoutConstants.HEADER_PANE_HEIGHT + 
                      LayoutConstants.SCORE_PANE_HEIGHT +
                      LayoutConstants.MESSAGE_PANE_HEIGHT +
                      (LayoutConstants.DICE_PANE_HEIGHT / 2));
        
        Rectangle box = new Rectangle(LayoutConstants.APP_WIDTH, LayoutConstants.DICE_PANE_HEIGHT);
        box.setFill(Color.GRAY);
        
        getChildren().addAll(box);
        
        final int DICE_MARGIN = 10;
        
        for (int i = 0; i < allDice.size(); i++) {
            Die die = allDice.get(i);
            die.setTranslateX((LayoutConstants.DIE_WIDTH + DICE_MARGIN) * (i - 2.5));
            getChildren().add(die);
        }
    }
    
    public static void rollDice() {
    	if(GamePanel.hasRolled == false) {
    		int diceNumber = 0;
       		for (Die die : allDice) {
       			if (!die.isLocked()) {
        			die.rollDie(diceNumber);
        		}
        		diceNumber++;
        	}
			GamePanel.hasRolled = true;
    	}
    }
    
    public static void lockSelectedDice() {
        for (Die die : allDice) {
            // Add your logic here to determine which dice should be locked based on the scoring rules
            if (die.isSelected()) {
                die.setLocked(true);
                
            }
        }
    }
    
    // Method to check if all dice are locked
    public boolean allDiceLocked() {
        for (Die die : allDice) {
            if (!die.isLocked()) {
                return false;
            }
        }
        return true;
    }
    
    // Method to unlock all dice
    public static void unlockAllDice() {
        for (Die die : allDice) {
            die.setLocked(false);
        }
    }
    
    // Method to unlock all dice
    public static void unselectAllDice() {
        for (Die die : allDice) {
            die.setSelect(false);
        }
    }
}
