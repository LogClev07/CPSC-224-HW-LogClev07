public class Hand {
    Die[] dice;
    boolean[] inTheMeld;

    public Hand() {
        dice = new Die[6];
        inTheMeld = new boolean[6];

        for (int i = 0; i < 6; i++) {
            dice[i] = new Die(1);
            inTheMeld[i] = false;
        }
    }
    public void rollDice() {
        for (int i = 0; i < 6; i++) {
            if (inTheMeld[i] == false){
                dice[i].roll();
            }
        }
    }
    public int[] getValueTotals() {
        // Used ChatGPT hint of utilizing an array of size 7 instead of 6
        int[] valueTotals = new int[7];

        for (Die die : dice) {
            valueTotals[die.getValue()]++;
        }
        return valueTotals;
    }
    // Used ChatGPT to visualize possibilities of a Farkle
    public boolean detectFarkle() {
        int[] valueTotals = getValueTotals();
        boolean tripleExists = false;
        int numDoubles = 0;

        for (int val : valueTotals) {
            if (val > 2) {
                tripleExists = true;
            }
            if (val == 2) {
                numDoubles ++;
            }
        }
        // detect 1's and 5's
        if (valueTotals[1] > 0 || valueTotals[5] > 0 ) {
            return false;
        }
        // detect triple
        else if (tripleExists == true) {
            return false;

        }
        // detect triple doubles
        else if (numDoubles == 3) {
            return false;
        }
        return true;  
    }
    public Die getDieInstance(int index) {
        // ChatGPT used to learn about the IndexOutOfBoundsException
        if (index < -1 || index > 5) {
        throw new IndexOutOfBoundsException("Invalid index provided: " + index);
        }
        return dice[index];
    }
    public boolean isInMeld(int index) {
        return inTheMeld[index];
    }
    public void moveToMeld(int index) {
        inTheMeld[index] = true;
    
    }
    public void moveToHand (int index) {
        inTheMeld[index] = false;
    }
}
