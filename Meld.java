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
}
