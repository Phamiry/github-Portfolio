package application;

public class TakeTurn {
    DicePane dp;
    
    // Rolls the dice for the current player
    public static void roll(Player cplayer) {
        if (!GamePanel.hasRolled) {
            System.out.println(cplayer.name);
            for (int i = 0; i < 6; i++) {
                System.out.print(cplayer.dice[i] + " ");
            }
        }
    }
    
    // Ends the selection phase, adds points to round score, and checks for farkle
    public static void selection(Player cplayer) {
        GamePanel.hasRolled = false;
        
     // Score the selected dice
        Score.score(cplayer.selectedDiceValues(), cplayer.currentNumberOfDice, cplayer);
        
        double farkleProb = cplayer.farkleProbability();
        String hintMessage = "";
        double percentage = farkleProb;
       
        if (farkleProb > 50) {
            hintMessage = "High risk of Farkle! (" + String.format("%.2f", percentage) + "%)";
        } else {
            hintMessage = "Low risk of Farkle. (" + String.format("%.2f", percentage) + "%)";
        }
        System.out.println("\nHint: " + hintMessage);
        
        
        
        // Reset dice selection
        cplayer.resetDiceSelect();
        
        // Reset hasScored flag to allow rolling again
        GamePanel.hasScored = false;
    }
}