package application;
public class GamePanel {

	//creates 1 human and 3 computers
	static Player player1 =  new Human("human");
	static Player cp1 = new Computer("comp 1", true);
	static Player cp2 = new Computer("comp 2", false); 
	static Player cp3 = new Computer("comp 3", false);
	
	//prevents rolling again
	static boolean hasRolled = false;
	
	static boolean hasScored = false;
	
	static boolean canSelect = true;
	
	//creates an array that stores each player
	static Player[] playerID = {player1,cp1,cp2,cp3};
	//current player
	public static int currentPlayer = 0;
	public static int totalPlayers = 4;
	
	
	//score points
	public static void score() {
		Score.EndTurn(playerID[currentPlayer]);
		
	}
	
	//highest score
	public static int highestscore() {
		int highScore = 0;
		if(player1.score > cp1.score && player1.score > cp2.score && player1.score > cp3.score) {
			highScore = player1.score;
		}
		else if(cp1.score > cp2.score && cp1.score > cp3.score) {
			highScore = cp1.score;
		}
		else if(cp2.score > cp3.score) {
			highScore = cp2.score;
		}
		else {
			highScore = cp3.score;
		}
		return highScore;
	}
	
	public static void runTurn() {
		switch(currentPlayer) {
		case 0 : break;
		case 1 : playerID[currentPlayer].ComputerTurn(); break;
		case 2 : playerID[currentPlayer].ComputerTurn(); break;
		case 3 : playerID[currentPlayer].ComputerTurn(); break;
		}
		
	}
	
	
	public static void win() {
		String winningPlayer = "";
		if(player1.score > cp1.score && player1.score > cp2.score && player1.score > cp3.score) {
			winningPlayer = player1.name;
		}
		else if(cp1.score > cp2.score && cp1.score > cp3.score) {
			winningPlayer = cp1.name;
		}
		else if(cp2.score > cp3.score) {
			winningPlayer = cp2.name;
		}
		else {
			winningPlayer = cp3.name;
		}
		
		
		MessagePane.updateMessage(winningPlayer + " is the winner");
		
		
	}
}
