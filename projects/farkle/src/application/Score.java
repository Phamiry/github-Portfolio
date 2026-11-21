package application;

public class Score {
public static int turnScore = 0;

//returns the turnScore as a string
public static String makeString() {
	return turnScore + "";
}


//if current player farkles no score is added to player and players turn ends
	public static void Farkle() {
		System.out.println("farkle");
		GamePanel.playerID[GamePanel.currentPlayer].farkle = true;
		
		if(GamePanel.currentPlayer +1< GamePanel.totalPlayers) {
			GamePanel.currentPlayer ++;
		}
		else {
			GamePanel.currentPlayer = 0;
		}
		turnScore = 0;
		DicePane.unlockAllDice();
		DicePane.unselectAllDice();
		System.out.println("FARKLE");
		GamePanel.hasRolled = false;
		GamePanel.hasScored = false;
		GamePanel.runTurn();
	}
	
	//adds turn score to player score after player is done
	public static void EndTurn(Player player) {
		if(canScore()) {
			player.addScore(turnScore);
			GamePanel.playerID[GamePanel.currentPlayer].currentNumberOfDice = 6;
			if(GamePanel.currentPlayer +1< GamePanel.totalPlayers) {
				GamePanel.currentPlayer ++;
			}
			else {
				GamePanel.currentPlayer = 0;
			}
			turnScore = 0;
			GamePanel.hasRolled = false;
			GamePanel.playerID[GamePanel.currentPlayer].currentNumberOfDice = 6;
			GamePanel.runTurn();
		}
		
	}
	
	//check if player has 500 points this round, player cant score until they have 500 points
	public static boolean canScore() {
		if(turnScore >= 200) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//scores the dice
	public static void score(int[] dice, int nDice, Player cPlayer) {
		
		//convert dice into a sorted set showing how many one displayed as an int in the [0] position of a array
		int[] sortedDice = {0,0,0,0,0,0};
		for(int i =0;i<6;i++) {
			switch(dice[i]) {
			case 1 : sortedDice[0]++; break;
			case 2 : sortedDice[1]++; break;
			case 3 : sortedDice[2]++; break;
			case 4 : sortedDice[3]++; break;
			case 5 : sortedDice[4]++; break;
			case 6 : sortedDice[5]++; break;
			default : break;
			}
		}
		//for checking scores 
		boolean fourpair = false;
		boolean twotriple = false;
		boolean threepair = false;
		boolean straight = false;
		boolean farkle = true;
		
		//two triplets
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 3 && i != nDice-1) {
				for(int k = i+1;k<nDice;k++) {
					if(sortedDice[k] == 3) {
						turnScore += 2500;
						cPlayer.currentNumberOfDice -= 6;
						twotriple = true;
						farkle = false;
					}
				}
			}
		}
		
		//four of any number and a pair
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 4) {
				for(int k =0;k<6;k++ ) {
					if(sortedDice[i] == 2) {
						turnScore += 1500;
						cPlayer.currentNumberOfDice -= 6;
						fourpair = true;
						farkle = false;
					}
				}
			}
		}
		
		//three pairs
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 2 && i != nDice-1) {
				for(int k = i+1;k<6;k++) {
					if(sortedDice[k] == 2 && k != nDice-1) {
						for(int j = k+1;j<6;j++) {
							if(sortedDice[j] == 2) {
								turnScore +=1500;
								cPlayer.currentNumberOfDice -= 6;
								threepair = true;
								farkle = false;
							}
						}
						
					}
				}
			}
		}
		
		//straight
		if(sortedDice[0] == 1 && sortedDice[1] == 1 && sortedDice[2] == 1 && sortedDice[3] == 1 && sortedDice[4] == 1 && sortedDice[5] == 1) {
			turnScore += 1500;
			cPlayer.currentNumberOfDice -= 6;
			straight = true;
			farkle = false;
		}
		
		//six of any number
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 6) {
				turnScore += 3000;
				cPlayer.currentNumberOfDice -= 6;
				farkle = false;
			}
		}
		
		//five of any number
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 5) {
				turnScore += 2000;
				cPlayer.currentNumberOfDice -= 5;
				farkle = false;
			}
		}
		//four of any number
		for(int i =0;i<6;i++) {
				if(sortedDice[i] == 4 && fourpair == false) {
					turnScore += 1000;
					cPlayer.currentNumberOfDice -= 4;
					farkle = false;
				}
		}
				
		//three of each numbers
		for(int i =0;i<6;i++) {
			if(sortedDice[i] == 3 && twotriple == false) {
				switch(i) {
				case 0 : turnScore += 300; break;
				case 1 : turnScore += 200; break;
				case 2 : turnScore += 300; break;
				case 3 : turnScore += 400; break;
				case 4 : turnScore += 500; break;
				case 5 : turnScore += 600; break;
				}
				cPlayer.currentNumberOfDice -= 3;
				farkle = false;
			}
		}
		
		//single 1's
		if((sortedDice[0] == 1 || sortedDice[0] == 2) && fourpair == false && threepair == false && straight == false) {
			turnScore += 100 * sortedDice[0];
			cPlayer.currentNumberOfDice -= sortedDice[0];
			farkle = false;
		}
		
		//single 5's
		if((sortedDice[4] == 1 || sortedDice[4] == 2) && fourpair == false && threepair == false && straight == false) {
			turnScore += 50 * sortedDice[4];
			cPlayer.currentNumberOfDice -= sortedDice[4];
			farkle = false;
		}
		
		//all dice are scored
		if(cPlayer.currentNumberOfDice == 0) {
			cPlayer.currentNumberOfDice = 6;
			DicePane.unlockAllDice();
			DicePane.unselectAllDice();
			System.out.println("Score score all dice scored");
		}
		
		//0 points
		if(farkle == true) {
			System.out.println("Score score farkle");
			cPlayer.currentNumberOfDice = 6;
			Farkle();
		}
		DicePane.lockSelectedDice();
		DicePane.unselectAllDice();
		GamePanel.hasRolled = false;
		System.out.println("round score " + turnScore);
	}
}
