package application;
public class Player {
    public static boolean ishuman = true;
	public int score = 0;
    public String name;
    public int currentNumberOfDice = 6;
    public int[] dice = new int[6]; 
    boolean[] selectedDice = {false,false,false,false,false,false,};
    int remainingturns = 0;
    public boolean farkle = false;
    
    // sets up the player
    public Player(String nName) {
        name = nName;
        Dice die = new Dice();
        for(int i = 0; i < currentNumberOfDice; i++) {
            dice[i] = die.roll();
        }
    }
    
    // adds turn score to the running total and check for win condition
    public void addScore(int turnScore) {
        score += turnScore;
        
        switch(GamePanel.currentPlayer) {
		case 3 : ScoreBoard.updateAI3Score(GamePanel.playerID[3].score); break;
		case 0 : ScoreBoard.updatePlayer1Score(GamePanel.playerID[0].score); break;
		case 1 : ScoreBoard.updateAIScore(GamePanel.playerID[1].score); break;
		case 2 : ScoreBoard.updateAI2Score(GamePanel.playerID[2].score); break;
		}
        
        System.out.println(name + " score is " + score);
        
        if(remainingturns == 1){
            GamePanel.win();
        }
        if(score >= 10000) {
            remainingturns = 1;
        }
        
    }

    // gets the values of the selected dice
    public int[] selectedDiceValues() {
        int[] selctDice = new int[6];
        for(int i = 0;i<6;i++) {
            if(selectedDice[i] == true) {
                selctDice[i] = dice[i];
            }
            else {
                selctDice[i] = 0;
            }
        }
        return selctDice;
    }
    
    // resets the dice selection
    public void resetDiceSelect() {
        for(int i = 0; i < 6; i++) {
            selectedDice[i] = false;
        }
    }
    
    // rerolls dice
    public void reroll() {
        Dice die = new Dice();
        for(int i = 0; i < currentNumberOfDice; i++) {
            dice[i] = die.roll();
        }
    }

    // toggles the selection of dice
    public void diceSelect(int diceID) {

        if(selectedDice[diceID] == true) {
            selectedDice[diceID] = false;
            System.out.println(diceID + " " + selectedDice[diceID]);
        }
        else {
            selectedDice[diceID] = true;
            System.out.println(diceID + " " + selectedDice[diceID]);
            
        }
    }

    // Calculate the probability of a farkle given the remaining number of dice
    public double farkleProbability() {
        // Calculate the probability based on the current dice configuration
        int remainingDice = currentNumberOfDice;
        double probabilityFarkle = 0;
        switch(remainingDice) {
        case 1 : probabilityFarkle = 66.67; break;
        case 2 : probabilityFarkle = 44.44; break;
        case 3 : probabilityFarkle = 27.78; break;
        case 4 : probabilityFarkle = 15.74; break;
        case 5 : probabilityFarkle = 7.72; break;
        case 6 : probabilityFarkle = 2.31; break;
        }
        return probabilityFarkle;
    }

	public void ComputerTurn() {
		// TODO Auto-generated method stub
		
	}
	
}
