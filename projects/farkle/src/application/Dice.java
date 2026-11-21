package application;

import java.util.Random;

public class Dice {
	private int faceValue;
	Random rand = new Random();
	
	public int roll() {
		faceValue = rand.nextInt(6)+1;
		
		return faceValue;
	}
}
