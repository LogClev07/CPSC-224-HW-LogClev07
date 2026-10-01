// Had ChatGPT assist me with learning Java testing functionality

import static org.junit.jupiter.api.Assertions.*; // Gives me access to assertion statements
import org.junit.jupiter.api.Test; // Allows for @Test tag so junit knows what funcs are tests

public class FarkleTest {

    /**
     * Tests scoring for a straight.
     */
    @Test
    public void testStraight(){
        Meld meld = new Meld();

        meld.addDie(new Die(6));
        meld.addDie(new Die(5));
        meld.addDie(new Die(4));
        meld.addDie(new Die(3));
        meld.addDie(new Die(2));
        meld.addDie(new Die(1));

        int [] results = meld.calculateScoreAndScoringDice();

        assertEquals(1000, results[0]);
        assertEquals(6, results[1]);

    }

    /**
     * Tests scoring for triple doubles.
     */
    @Test
    public void testTripleDoubles() {
        Meld meld = new Meld();

        meld.addDie(new Die(2));
        meld.addDie(new Die(2));
        meld.addDie(new Die(3));
        meld.addDie(new Die(3));
        meld.addDie(new Die(4));
        meld.addDie(new Die(4));

        int[] results = meld.calculateScoreAndScoringDice();

        assertEquals(750, results[0]);
        assertEquals(6, results[1]);
    }

    /**
     * Tests scoring for rolling a single 1.
     */
    @Test
    public void testSingleOne() {
        Meld meld = new Meld();

        meld.addDie(new Die(1));

        int[] results = meld.calculateScoreAndScoringDice();

        assertEquals(100, results[0]);
        assertEquals(1, results[1]);
    }

    /**
     * Tests that a user can set their player name.
     */
    @Test
    public void testPlayerName() {
        Player player = new Player("Logan");

        assertEquals("Logan", player.getPlayerName());
    }
    
    /**
     * Tests a known Farkle hand for correctly detecting Farkle.
     */
    @Test
    public void testFarkle() {
        Hand hand = new Hand();

        hand.getDieInstance(0).value = 2;
        hand.getDieInstance(1).value = 2;
        hand.getDieInstance(2).value = 3;
        hand.getDieInstance(3).value = 3;
        hand.getDieInstance(4).value = 4;
        hand.getDieInstance(5).value = 6;

        assertTrue(hand.detectFarkle());
    }
}
