public class Hand {
    Die[] dice;
    boolean[] inMeld;

    public Hand() {
        dice = new Die[6];
        inMeld = new boolean[6];

        for (int i = 0; i < 6; i++) {
            dice[i] = new Die(1);
            inMeld[i] = false;
        }
    }
    public void rollDice() {
        for (int i = 0; i < 6; i++) {
            if (inMeld[i] = false){
                dice[i].roll();
            }
        }
    }
    public void removeDice(int index) {
        inMeld[index] = true;

    }
    public void addDice (int index) {
        inMeld[index] = false;
    }
}
