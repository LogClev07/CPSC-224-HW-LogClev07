import java.util.Random;

public class die {

    int value;

    public die(int value) {
        this.value = value;
    }

    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }
}
