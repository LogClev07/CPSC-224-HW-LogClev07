import java.util.Random;
// utilized ChatGPT to help understand Random class
// functionaility from java.util package

public class Die {

    int value;

    public Die(int value) {
        this.value = value;
    }

    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return this.value;
    }
}
