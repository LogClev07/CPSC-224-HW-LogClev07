public class Hand {
    Die[] dice;

    public Hand() {
        dice = new Die[6];

        for (int i = 0; i < 6; i++) {
            dice[i] = new Die(1);
        }
    }
}
