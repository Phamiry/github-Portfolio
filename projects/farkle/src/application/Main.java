package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	GamePanel gp = new GamePanel();
	
	private ScoreBoard scoreBoard;
	private MessagePane messageCenter;
	private DicePane diceController;
	private ButtonPanes buttonPanes;
	private boolean resetGame = true;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, LayoutConstants.APP_WIDTH,LayoutConstants.APP_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			initLayout(root);
			
			resetGame();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void initLayout(BorderPane root) {	
		initHeaderPane(root);
		initScorePane(root);
		initMessagePane(root);
		initDicePane(root);
		initButtonPanes(root);
	}
	private void initHeaderPane(BorderPane root) {	
		root.getChildren().add(new HeaderPane());
	}
	private void initScorePane(BorderPane root) {
		scoreBoard = new ScoreBoard();
		root.getChildren().add(scoreBoard);
	}
	private void initMessagePane(BorderPane root) {
		messageCenter = new MessagePane();
		root.getChildren().add(messageCenter);
	}
	private void initDicePane(BorderPane root) {
		diceController = new DicePane();
		root.getChildren().add(diceController);
	}
	private void initButtonPanes(BorderPane root) {
		buttonPanes = new ButtonPanes();
		buttonPanes.setRollButtonOnAction(onRollButtonAction());
		buttonPanes.setPlayButtonOnAction(onPlayButtonAction());
		buttonPanes.setScoreButtonOnAction(onScoreButtonAction());
		buttonPanes.setEndTurnButtonOnAction(onEndTurnButtonAction());
		root.getChildren().add(buttonPanes);	
	}
	private void resetGame() {
		buttonPanes.setRollButtonVisible(false);
		buttonPanes.setPlayButtonVisible(true);
		buttonPanes.setScoreButtonVisible(false);
		buttonPanes.setEndTurnButtonVisible(false);
	}
	// roll button
	private EventHandler<ActionEvent> onRollButtonAction() {
		return new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
            	if(diceController.allDiceLocked()) {
            		diceController.unlockAllDice();
            	}
            	System.out.println("Roll Button Clicked");
            	buttonPanes.setEndTurnButtonDisable(false);
            	System.out.println("onRollButtonAction Main");
            	diceController.rollDice();
            	gp.hasScored = false;
            	gp.canSelect = true;
                if(gp.playerID[gp.currentPlayer].remainingturns == 1){
                    GamePanel.win();
                }
            }
        };
	}
	//play button
	private EventHandler<ActionEvent> onPlayButtonAction() {
		return new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
            	System.out.println("Play Button Clicked");
            	 startGame();
            }
        };
	}
	//score button
	private EventHandler<ActionEvent> onScoreButtonAction() {
		return new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
            	if(gp.hasScored == false) {
            		TakeTurn.selection(gp.playerID[gp.currentPlayer]);
            		scoreBoard.updateRunningScore(Score.turnScore);
            		//add lock selected dice
            		diceController.lockSelectedDice();
            		diceController.unselectAllDice();
            	}
            	gp.hasScored = true;
            	gp.canSelect = false;
            }
        };
	}
	//end turn button
	private EventHandler<ActionEvent> onEndTurnButtonAction() {
		return new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
            	if(gp.hasScored == true && Score.canScore()) {
            		diceController.unlockAllDice();
            		diceController.unselectAllDice();
            		gp.score();
            		gp.canSelect = true;
            		//gp.runTurn();
            	}
            }
        };
	}

	
	private void startGame() {
		buttonPanes.setRollButtonVisible(true);
		buttonPanes.setPlayButtonVisible(false);
		buttonPanes.setScoreButtonVisible(true);
		buttonPanes.setEndTurnButtonVisible(true);
		buttonPanes.setEndTurnButtonDisable(true);
		//After clicking play, the "Click Play Button" is updated and removed
		messageCenter.updateMessage("");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
