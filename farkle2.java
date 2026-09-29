import java.util.Scanner;

public class farkle2 {

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
                System.out.println(
                        "Invalid mixed input. To quit please only press Q!"
                    );
                    continue;
            }

            else if (userChoice.indexOf('K') != -1 && userChoice.length() > 1) {
                System.out.println(
                        "Invalid mixed input. To bank please only press K"
                    );
                    continue;
            }

            for (char letter : userChoice.toCharArray()) {
                if ("ABCDEFKQ".indexOf(letter) == -1) {
                    validChoice = false;
                    System.out.println(
                        "Invalid input. Please choose from A,B,C,D,E,F,K,Q"
                    );
                    break;
                }
            }

            if (validChoice == true && userChoice.length() > 0) {
                return userChoice;
            }
        }
    }

    public static void chooseMeldDice (Hand hand, Meld meld, String userChoice) {

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

    public static void playRound(Hand hand, Meld meld) { 
        // Used ChatGPT to help learn Scanner class functionality 
        Scanner scanner = new Scanner(System.in); 
        int turnScore = 0;
        boolean validMeld = false;

        hand.rollDice(); 
        farkle2.checkForFarkle(hand, meld);
        while (validMeld == false) {
            String userChoice = farkle2.getUserChoice(scanner);
            farkle2.chooseMeldDice(hand, meld, userChoice);
            int numScoringDice = meld.calculateScoreAndScoringDice()[1];
            validMeld = farkle2.validateMeld(meld, numScoringDice);
            if (validMeld == false) {
                System.out.println("Selected meld is invalid. Try again.");
                continue;
            }
        }
        turnScore += meld.calculateScoreAndScoringDice()[0];
    }
}
