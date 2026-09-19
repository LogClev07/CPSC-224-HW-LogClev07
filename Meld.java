import java.util.ArrayList; 
 
/**
 * Represents a meld of selected dice in Farkle.
 */
public class Meld { 
 
    private ArrayList<Die> dice; 
 
    /**
     * Creates an empty meld.
     */
    public Meld() { 
        dice = new ArrayList<>(); 
    } 
 
    /**
     * Adds a die to the meld.
     */
    public void addDie(Die die) { 
        dice.add(die); 
    } 
 
    /**
     * Removes a die from the meld.
     */
    public void removeDie(Die die) { 
        dice.remove(die); 
    } 
 
    /**
     * Returns the quantity of each die value in the meld.
     */
    public int[] findMeldValueTotals() { 
        int[] meldValueTotals = new int[7]; 
 
        for (Die die : dice) { 
            meldValueTotals[die.getValue()]++; 
        } 
 
        return meldValueTotals; 
    } 
    // Used ChatGPT to give hints regarding how to tackle scoring priority 
    /**
     * Calculates and returns the total score of the meld.
     */
    public int calculateScore() { 
        int score = 0; 
        int numSoloValues = 0; 
        int numDoubles = 0; 
 
        boolean tripleOnes = false; 
        boolean tripleTwos = false; 
        boolean tripleThrees = false; 
        boolean tripleFours = false; 
        boolean tripleFives = false; 
        boolean tripleSixes = false; 
 
        int[] meldValueTotals = findMeldValueTotals(); 
 
        // Finding the number of singles, doubles, and triple values 
        for (int i = 1; i <= 6; i++) { 
 
            if (meldValueTotals[i] == 1) { 
                numSoloValues++; 
            } else if (meldValueTotals[i] == 2) { 
                numDoubles++; 
            } else if (meldValueTotals[i] >= 3) { 
 
                if (i == 1) { 
                    tripleOnes = true; 
                } else if (i == 2) { 
                    tripleTwos = true; 
                } else if (i == 3) { 
                    tripleThrees = true; 
                } else if (i == 4) { 
                    tripleFours = true; 
                } else if (i == 5) { 
                    tripleFives = true; 
                } else if (i == 6) { 
                    tripleSixes = true; 
                } 
            } 
        } 
        // Checking for possible straight 
        if (numSoloValues == 6) { 
            return 1000; 
        } 
 
        // Checking for triple doubles 
        else if (numDoubles == 3) { 
            return 750; 
        } 
 
        // Scoring triple ones 
        if (tripleOnes) { 
            int extraValues = meldValueTotals[1] - 3; 
            score = score + 1000 + (100 * extraValues); 
        } 
 
        // Scoring triple twos 
        if (tripleTwos) { 
            int extraValues = meldValueTotals[2] - 3; 
            score = score + 200 + (200 * extraValues); 
        } 
 
        // Scoring triple threes 
        if (tripleThrees) { 
            int extraValues = meldValueTotals[3] - 3; 
            score = score + 300 + (300 * extraValues); 
        } 
 
        // Scoring triple fours 
        if (tripleFours) { 
            int extraValues = meldValueTotals[4] - 3; 
            score = score + 400 + (400 * extraValues); 
        } 
 
        // Scoring triple fives 
        if (tripleFives) { 
            int extraValues = meldValueTotals[5] - 3; 
            score = score + 500 + (500 * extraValues); 
        } 
 
        // Scoring triple sixes 
        if (tripleSixes) { 
            int extraValues = meldValueTotals[6] - 3; 
            score = score + 600 + (600 * extraValues); 
        } 
 
        // Scoring leftover ones 
        if (tripleOnes == false) { 
            score = score + (meldValueTotals[1] * 100); 
        } 
 
        // Scoring leftover fives 
        if (tripleFives == false) { 
            score = score + (meldValueTotals[5] * 50); 
        } 
 
        return score; 
    } 
}
