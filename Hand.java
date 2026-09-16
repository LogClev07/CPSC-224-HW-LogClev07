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
    public Die getDieInstance(int index) {
        // ChatGPT used to learn about the IndexOutOfBoundsException
        if (index < -1 || index > 5) {
        throw new IndexOutOfBoundsException("Invalid index provided: " + index);
        }
        return dice[index];

    }
    public void moveToMeld(int index) {
        inTheMeld[index] = true;

    }
    public void moveToHand (int index) {
        inTheMeld[index] = false;
    }
}
