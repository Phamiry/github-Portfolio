package application;

public class Computer extends Player{

	boolean AiDificulty;
	
	public Computer(String nName, boolean dificulty) {
		super(nName);
		
		//sets the dificulty for the computer true = hard. false = easy
		AiDificulty = dificulty;
		ishuman = false;
	}

	public void ComputerTurn(){
		farkle = false;
		//split the ai into its dificulty true is the hard AI
		if(AiDificulty == true) {
			if(score > GamePanel.highestscore()) {
				while(Score.turnScore < 200 && farkle == false) {
					
					//roll
					DicePane.rollDice();
					
					//score
					Score.score(dice, currentNumberOfDice, GamePanel.playerID[GamePanel.currentPlayer]);
					ScoreBoard.updateRunningScore(Score.turnScore);
					
				}
			}
			else{
				while(Score.turnScore < 400 && farkle == false) {
					
					//roll
					DicePane.rollDice();
					
					//score
					Score.score(dice, currentNumberOfDice, GamePanel.playerID[GamePanel.currentPlayer]);
					ScoreBoard.updateRunningScore(Score.turnScore);
					
				}
			}
			
			
			
			
			if(farkle == false) {
				GamePanel.score();
			}
		}
		//this is the easy AI
		else {
			while(Score.turnScore < 200 && farkle == false) {
				
				//roll
				DicePane.rollDice();
				
				//score
				Score.score(dice, currentNumberOfDice, GamePanel.playerID[GamePanel.currentPlayer]);
				ScoreBoard.updateRunningScore(Score.turnScore);
				
			}
			if(farkle == false) {
				GamePanel.score();
			}
		}
	}
}