import java.util.Scanner;

public class farkle2 {

    public static void main() {

    }

    public static boolean checkForFarkle(Hand hand, Meld meld) {
        if (hand.detectFarkle() == true) {
            System.out.println("You rolled a Farkle! Please try again.");
            Farkle.display(hand, meld, false);
            return true;
        }

        return false;
    }

    public static String getUserChoice(Scanner scanner) {

        while (true) {
            String userChoice = scanner.nextLine().trim().toUpperCase();
            boolean validChoice = true;

            if (userChoice.indexOf('Q') != -1 && userChoice.length() > 1) {
                System.out.println("Invalid mixed input. To quit please only press Q!");
                continue;
            }

            else if (userChoice.indexOf('K') != -1 && userChoice.length() > 1) {
                System.out.println("Invalid mixed input. To bank please only press K");
                continue;
            }

            for (char letter : userChoice.toCharArray()) {
                if ("ABCDEFKQ".indexOf(letter) == -1) {
                    validChoice = false;
                    System.out.println("Invalid input. Please choose from A,B,C,D,E,F,K,Q");
                    break;
                }
            }

            if (validChoice == true && userChoice.length() > 0) {
                return userChoice;
            }
        }
    }

    public static void chooseMeldDice(
        Hand hand,
        Meld meld,
        String userChoice
    ) {

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

    public static boolean validateMeld(Meld meld, int numScoringDice) {
        if (numScoringDice == meld.getMeldSize()) {
            return true;
        }

        return false;
    }

    public static boolean detectHotHand(int numScoringDice) {
        if (numScoringDice == 6) {
            return true;
        }

        return false;
    }

    public static void playRound(
        Hand hand,
        Meld meld,
        Player player
    ) {
        Scanner scanner = new Scanner(System.in);

        int turnScore = 0;
        boolean turnFinished = false;

        while (turnFinished == false) {

            hand.rollDice();

            if (checkForFarkle(hand, meld)) {
                return;
            }

            boolean validMeld = false;
            int[] scoreResults = null;

            while (validMeld == false) {
                Farkle.display(hand, meld, true);
                String userChoice = getUserChoice(scanner);

                if (userChoice.equals("Q")) {
                    System.out.println("Exiting game... Come play again soon!");
                    return;
                }

                chooseMeldDice(hand, meld, userChoice);
                scoreResults = meld.calculateScoreAndScoringDice();
                int numScoringDice = scoreResults[1];
                validMeld = validateMeld(meld, numScoringDice);

                if (validMeld == false) {
                    System.out.println("Selected meld is invalid. Try again.");
                }
            }

            turnScore += scoreResults[0];

            System.out.println("Current turn score: " + turnScore);
            System.out.print("Enter R to reroll or K to bank: ");
            String nextChoice = scanner.nextLine().trim().toUpperCase();

            if (nextChoice.equals("R")) {
                System.out.println("You've chosen to roll again");
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
