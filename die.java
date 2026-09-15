import java.util.Random;

public class Die {

    int value;

    public Die(int value) {
        this.value = value;
    }

    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }
}
