import java.util.Scanner; 
 
/**
 * Runs the Farkle game.
 */
public class Farkle { 

    /**
     * Creates the hand and meld and starts the game.
     */
    public static void main(String[] args) { 
        Hand hand = new Hand(); 
        Meld meld = new Meld(); 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter player name: ");
        String playerName = scanner.nextLine().trim();

        if (playerName.length() == 0) {
            playerName = "Unknown Player";
        }
        Player player = new Player(playerName);
 
        System.out.println("");
        showBanner();
        playRound(hand, meld, player, scanner); 

        scanner.close();
    } 
    public static void showBanner() {
        System.out.println("**********************************************************************");
        System.out.printf("*%45s%23s%n", "Zag Farkle by Logan Clevenger!", "*");
        System.out.printf("*%41s%27s%n", "Copyright: 2026", "*");
        System.out.println("**********************************************************************");
    }

    /**
     * Displays the current hand, meld, score, and optional menu.
     */
    public static void display(Hand hand, Meld meld, Player player, boolean showMenu) { 
        int[] handValueTotals = hand.getValueTotals(); 
 
        // Used ChatGPT to understand how to use printf 
        // Also used ChatGPT to help adapt spacing from CPP example 
        System.out.println("\n***************Let's Play Farkle!***************"); 
        System.out.println("Player: " + player.getPlayerName());
        System.out.printf("%-28s %-6s %-6s %-6s %-6s %-6s %-6s%n", 
            "Hand", hand.getDieInstance(0).getValue(), 
            hand.getDieInstance(1).getValue(), hand.getDieInstance(2).getValue(), 
            hand.getDieInstance(3).getValue(), hand.getDieInstance(4).getValue(), 
            hand.getDieInstance(5).getValue() 
        ); 
        System.out.printf("%-28s %-6s %-6s %-6s %-6s %-6s %-6s%n", 
            "Quantity of each die value:", handValueTotals[1], handValueTotals[2], 
            handValueTotals[3], handValueTotals[4], handValueTotals[5], 
            handValueTotals[6] 
        ); 
        System.out.println("*************************** Current hand and meld"); 
        System.out.println("*******************"); 
        System.out.printf("%-6s %-6s | %-6s%n", "Die", "Hand", "Meld"); 
        System.out.println("--------------+---------------"); 
        for (int i = 0; i < 6; i++) { 
            // Used ChatGPT to understand how to loop through alphabet 
            char letter = (char) ('A' + i); 
            int currDieValue = hand.getDieInstance(i).getValue(); 
            if (hand.isInMeld(i) == false) { 
                System.out.printf("(%c)    %-6s | %-6s%n", letter, currDieValue, ""); 
                continue; 
            } 
            System.out.printf("(%c)    %-6s | %-6s%n", letter, "", currDieValue); 
        } 
        System.out.println("--------------+---------------"); 
        System.out.printf("%16sMeld Score: %d%n", "", meld.calculateScoreAndScoringDice()[0]); 
        System.out.println(); 
        if (showMenu == true) { 
            System.out.println("(Q) Quit game");
            System.out.println("(X) Confirm Meld"); 
            System.out.println();
            System.out.println("If entering multiple inputs - enter letters with no spaces!"); 
            System.out.print("Enter letter for your choice: A,B,C,D,E,F,X,Q: "); 
        } 
    }

    /**
    *Checks whether the current dice contain a Farkle.
    */
    public static boolean checkForFarkle(Hand hand, Meld meld, Player player) {
        if (hand.detectFarkle() == true) {
            System.out.println("");
            System.out.println("You rolled a Farkle :( Better luck next time!");
            Farkle.display(hand, meld, player, false);
            return true;
        }

        return false;
    } 

    /**
    * Gets a valid choice from the user.
    */
    public static String getUserChoice(Scanner scanner) {

        while (true) {
            String userChoice = scanner.nextLine().trim().toUpperCase();
            boolean validChoice = true;

            if (userChoice.indexOf('Q') != -1 && userChoice.length() > 1) {
                System.out.println("Invalid mixed input. To quit please only press Q!");
                continue;
            }
            else if (userChoice.indexOf('X') != -1 && userChoice.length() > 1) {
                System.out.println("Invalid mixed input. To confirm meld please only press X!");
                continue;
            }

            for (char letter : userChoice.toCharArray()) {
                if ("ABCDEFXQ".indexOf(letter) == -1) {
                    validChoice = false;
                    System.out.println("Invalid input. Please choose from A,B,C,D,E,F,X,Q");
                    break;
                }
            }

            if (validChoice == true && userChoice.length() > 0) {
                return userChoice;
            }
        }
    }

    /**
    * Adds or removes selected dice from the meld.
    */
    public static void chooseMeldDice(Hand hand, Meld meld, String userChoice) {

        if (userChoice.indexOf('A') != -1) {
            if (hand.isInMeld(0) == false) {
                hand.moveToMeld(0);
                meld.addDie(hand.getDieInstance(0));
            }
            else {
                hand.moveToHand(0);
                meld.removeDie(hand.getDieInstance(0));
            }
        }

        if (userChoice.indexOf('B') != -1) {
            if (hand.isInMeld(1) == false) {
                hand.moveToMeld(1);
                meld.addDie(hand.getDieInstance(1));
            }
            else {
                hand.moveToHand(1);
                meld.removeDie(hand.getDieInstance(1));
            }
        }

        if (userChoice.indexOf('C') != -1) {
            if (hand.isInMeld(2) == false) {
                hand.moveToMeld(2);
                meld.addDie(hand.getDieInstance(2));
            }
            else {
                hand.moveToHand(2);
                meld.removeDie(hand.getDieInstance(2));
            }
        }

        if (userChoice.indexOf('D') != -1) {
            if (hand.isInMeld(3) == false) {
                hand.moveToMeld(3);
                meld.addDie(hand.getDieInstance(3));
            }
            else {
                hand.moveToHand(3);
                meld.removeDie(hand.getDieInstance(3));
            }
        }

        if (userChoice.indexOf('E') != -1) {
            if (hand.isInMeld(4) == false) {
                hand.moveToMeld(4);
                meld.addDie(hand.getDieInstance(4));
            }
            else {
                hand.moveToHand(4);
                meld.removeDie(hand.getDieInstance(4));
            }
        }

        if (userChoice.indexOf('F') != -1) {
            if (hand.isInMeld(5) == false) {
                hand.moveToMeld(5);
                meld.addDie(hand.getDieInstance(5));
            }
            else {
                hand.moveToHand(5);
                meld.removeDie(hand.getDieInstance(5));
            }
        }
    }

    /**
     * Checks whether the current meld is valid.
    */
    public static boolean validateMeld(Meld meld, int numScoringDice) {
        // ChatGPT helped identify missed edge case of empty meld being valid.
        if (meld.getMeldSize() > 0 && numScoringDice == meld.getMeldSize()) {
        return true;
        }

        return false;
    }

    /**
    * Checks whether the player has a Hot Hand.
    */
    public static boolean detectHotHand(Hand hand) {
        if (hand.getMeldDiceTotal() == 6) {
            return true;
        }

        return false;
    }

    /**
    * Plays a single round of Farkle.
    */
    public static void playRound(Hand hand, Meld meld, Player player, Scanner scanner) {
        // Had ChatGPT help with debugging and syntax organization

        int turnScore = 0;
        boolean turnFinished = false;

        while (turnFinished == false) {

            hand.rollDice();

            if (checkForFarkle(hand, meld, player) == true) {
                return;
            }

            boolean validMeld = false;
            int[] scoreResults = null;
            int numScoringDice = 0;

            while (validMeld == false) {
                Farkle.display(hand, meld, player, true);
                String userChoice = getUserChoice(scanner);

                if (userChoice.equals("Q")) {
                    System.out.println("Exiting game... Come play again soon!");
                    System.out.println("Current total score: " + player.getBankedScore());
                    return;
                }

                if (userChoice.equals("X")) {
                    scoreResults = meld.calculateScoreAndScoringDice();
                    numScoringDice = scoreResults[1];
                    validMeld = validateMeld(meld, numScoringDice);
                    
                    if (validMeld == false) {
                    System.out.println("");
                    System.out.println("Selected meld is invalid. Try again.");
                    }
                }

                chooseMeldDice(hand, meld, userChoice);

            }

            turnScore += scoreResults[0];

            boolean hotHand = detectHotHand(hand);

            if (hotHand == true) {
                System.out.println("**********************************************************************");
                System.out.printf("*%39s%30s%n", "HOT HAND!", "*");
                System.out.println("*                                                                    *");
                System.out.printf("*%58s%11s%n", "You used all 6 dice in scoring melds!", "*");
                System.out.printf("*%58s%11s%n", "Roll 6 new dice, or bank and end your turn?", "*");
                System.out.println("*                                                                    *");
                System.out.printf("*%48s%21s%n", "[R] Roll Again     [K] Bank", "*");
                System.out.println("**********************************************************************");
            }

            String nextChoice = null;

            System.out.println("Current turn score: " + turnScore);
            System.out.print("Enter R to reroll or K to bank: ");

            boolean validNextChoice = false;

            while (validNextChoice == false) {
                nextChoice = scanner.nextLine().trim().toUpperCase();

                if (nextChoice.length() > 1) {
                    System.out.println("Please only enter 1 input. Try again!");
                    continue;
                }

                if (nextChoice.indexOf('R') == -1 && nextChoice.indexOf('K') == -1) {
                    System.out.println("Please enter a valid choice: R or K");
                    continue;
                }

                validNextChoice = true;
            }

            if (nextChoice.equals("R")) {
                System.out.println("You've chosen to roll again");
                meld.clearMeld();

                if (hotHand == true) {
                    meld.clearMeld();
                    hand.resetDiceBackToHand();
                }

                continue;
            }

            if (nextChoice.equals("K")) {
                player.addTurnScore(turnScore);
                System.out.println("Congrats! You banked " + turnScore + " points.");
                turnFinished = true;
            }
        }
    }
}
