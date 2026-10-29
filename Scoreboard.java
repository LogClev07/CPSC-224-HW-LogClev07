import java.util.ArrayList;
import java.util.Scanner;

public class Scoreboard {
    private int winningPoints;
    private ArrayList<Player> players;
    private ArrayList<String> defaultNames;
    private Player activePlayer;

    /**
     * Returns the winning points for this game of Farkle
     */
    public int getWinningPoints() {
        return this.winningPoints;
    }
    
    /**
     * Returns the player currently playing their turn
     */
    public Player getActivePlayer() {
        return this.activePlayer;
    }

    /**
     * Prints a nice representation of all player's scores
     */
    public void printScoreboard() {
        System.out.println("Current Player Scores:");
        for (Player player : players) {
            System.out.println(player.getPlayerName() + "'s score: " + player.getBankedScore());
        }
        System.out.println("");
    }

    /**
     * Switches active player to the next player in line.
     * Will return false if the player has met 
     * or exceeded the winning score.
     */
    public boolean switchActivePlayer() {
        if (this.checkWinCondition()) {
            return false;
        }
        if (players.indexOf(this.activePlayer) == players.size() - 1) {
            this.activePlayer = players.get(0);
            return true;
        }
        this.activePlayer = players.get(players.indexOf(this.activePlayer) + 1);
        return true;
    }

    /**
     * Checks if active player has achieved the minimum 
     * winning score to enter endgame
     */
    public boolean checkWinCondition() {
        if (this.activePlayer.getBankedScore() >= this.winningPoints) {
            return true;
        }
        return false;
        
    }

    /**
     * Gets player input for all start game settings
     */
    public void setUpScoreboard(Scanner scanner) {

        this.players = new ArrayList<>();
        
        this.defaultNames = new ArrayList<>();
        defaultNames.add("Pumpkin");
        defaultNames.add("Zombie");
        defaultNames.add("Ghost");
        defaultNames.add("Vampire");    

        // Get winning score
        while (true) {
            System.out.print("How many points would you like to play to in this game?: ");
            String winningpts = scanner.nextLine().trim();

            if (winningpts.length() == 0) {
                this.winningPoints = 10000;
                break;
            }
            else {
                try {
                    this.winningPoints = Integer.parseInt(winningpts);

                    if (this.winningPoints > 0) {
                        break;
                    }
                    else {
                        System.out.println("Please enter a positive number!");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer!");
                }
            }
        }
        
        // Get number of people playing
        int numPlayers;

        while (true) {
            System.out.print("How many players will there be?: ");
            String numPlayersInput = scanner.nextLine().trim();

            if (numPlayersInput.length() == 0) {
                numPlayers = 1;
                break;
            }
            else {
                try {
                    numPlayers = Integer.parseInt(numPlayersInput);

                    if (numPlayers > 0) {
                        break;
                    }
                    else {
                        System.out.println("Please enter at least 1 player!");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer!");
                }
            }
        }

        // Create player objects in players array list
        for (int num = 1; num < numPlayers + 1; num++) {
            System.out.print("Please enter player " + num + "'s name: ");
            String playerName = scanner.nextLine().trim();

            if (playerName.length() == 0) {
                if (defaultNames.size() > 0) {
                    playerName = defaultNames.remove(0);
                }
                else {
                    playerName = "Unknown Player #" + num;
                }
            }
            else {
                defaultNames.remove(playerName);
            }

            // Check for any duplicate names
            for (Player player : players) {
                if (player.getPlayerName().equals(playerName)) {
                    playerName = playerName + " #" + num;
                    break;
                }
            }

            Player player = new Player(playerName, num);
            players.add(player);
        }
        this.activePlayer = players.get(0);
    }
}
