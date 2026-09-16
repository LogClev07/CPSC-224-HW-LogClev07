import java.util.ArrayList;
public class Meld {

    private ArrayList<Die> dice;

    public Meld() {
        dice = new ArrayList<>();

    }
    public void addDie(Die die) {
        dice.add(die);
    }
    public void removeDie(Die die) {
        dice.remove(die);
    }
    public int[] findMeldValueTotals() {
        int[] meldValueTotals = new int[7];
        for (Die die : dice) {
            meldValueTotals[die.getValue()]++;
        }
        return meldValueTotals;
    }
}
