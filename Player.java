public class Player {
    private int bankedScore;
    private String name;
    
    public Player(String name) {
        this.bankedScore = 0;
        this.name = name;
    }

    public int getBankedScore() {
        return this.bankedScore;
    }

    public String getPlayerName() {
        return this.name;
    }

    public void addTurnScore(int turnScore) {
        this.bankedScore += turnScore;
    }
}
