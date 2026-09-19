import java.util.Random; 
// utilized ChatGPT to help understand Random class 
// functionaility from java.util package 
 
/**
 * Represents a six-sided die.
 */
public class Die { 
 
    int value; 
 
    /**
     * Creates a die with an initial value.
     */
    public Die(int value) { 
        this.value = value; 
    } 
 
    /**
     * Rolls the die and updates its value.
     */
    public void roll() { 
        Random random = new Random(); 
        this.value = random.nextInt(6) + 1; 
    } 
 
    /**
     * Returns the current value of the die.
     */
    public int getValue() { 
        return this.value; 
    } 
}
