/**
 * Represents a player in the Farkle game.
 */
public class Player {
    private int bankedScore;
    private String name;
    
    /**
     * Creates a player with a name and a starting score of 0.
     */
    public Player(String name) {
        this.bankedScore = 0;
        this.name = name;
    }

    /**
     * Returns the player's banked score.
     */
    public int getBankedScore() {
        return this.bankedScore;
    }

    /**
     * Returns the player's name.
     */
    public String getPlayerName() {
        return this.name;
    }

    /**
     * Adds the turn score to the player's banked score.
     */
    public void addTurnScore(int turnScore) {
        this.bankedScore += turnScore;
    }
}
