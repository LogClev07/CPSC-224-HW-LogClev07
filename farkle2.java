import java.util.Scanner;

public class farkle2 {

    public static void checkForFarkle(Hand hand, Meld meld, Scanner scanner) {
        if (hand.detectFarkle() == true) {  
            System.out.println("You rolled a Farkle! Please try again.");
            Farkle.display(hand, meld, false);  
            scanner.close(); 
            return;

        }
    }

    public static void playRound(Hand hand, Meld meld) { 
        // Used ChatGPT to help learn Scanner class functionality 
        Scanner scanner = new Scanner(System.in); 
        boolean finished = false; 
        hand.rollDice(); 
        if (hand.detectFarkle() == true) {  
            System.out.println("You rolled a Farkle! Please try again.");
            Farkle.display(hand, meld, false);  
            scanner.close(); 
            return; 
        } 
        while (finished == false) { 
            boolean validChoice = false; 
            Farkle.display(hand, meld, true); 
            while (validChoice == false) { 
                String userChoice =  scanner.nextLine().trim().toUpperCase(); 
                if (userChoice.length() != 1 || "ABCDEFKQ".contains(userChoice) == false) { 
                    System.out.println("Invalid input. Please choose a singular choice from A,B,C,D,E,F,K,Q"); 
                    continue; 
                } 
                else { 
                    validChoice = true; 
                } 
            // Quitting Game 
            if (userChoice.equals("Q")) { 
                System.out.println("Exiting game...  Come play again soon!");  
                finished = true; 
            } 
            // Banking points 
            else if (userChoice.equals("K")) { 
                if (meld.calculateScore() == 0) { 
                    System.out.println("You need more than 0 points to score!"); 
                    System.out.println(""); 
                } 
                else { 
                    System.out.println(""); 
                    System.out.println("Congrats! You scored: " + meld.calculateScore() + " points."); 
                    System.out.println(""); 
                    finished = true; 
                } 
            } 
            // Dice A-F  
            else if (userChoice.equals("A")) { 
                if (hand.isInMeld(0) == false) { 
                    hand.moveToMeld(0); 
                    meld.addDie(hand.getDieInstance(0)); 
                } 
                else { 
                    hand.moveToHand(0); 
                    meld.removeDie(hand.getDieInstance(0)); 
                } 
            } 
            else if (userChoice.equals("B")) { 
                if (hand.isInMeld(1) == false) { 
                    hand.moveToMeld(1); 
                    meld.addDie(hand.getDieInstance(1)); 
                } 
                else { 
                    hand.moveToHand(1); 
                    meld.removeDie(hand.getDieInstance(1)); 
                } 
            } 
            else if (userChoice.equals("C")) { 
                if (hand.isInMeld(2) == false) { 
                    hand.moveToMeld(2); 
                    meld.addDie(hand.getDieInstance(2)); 
                } 
                else { 
                    hand.moveToHand(2); 
                    meld.removeDie(hand.getDieInstance(2)); 
                } 
            } 
            else if (userChoice.equals("D")) { 
                if (hand.isInMeld(3) == false) { 
                    hand.moveToMeld(3); 
                    meld.addDie(hand.getDieInstance(3)); 
                } 
                else { 
                    hand.moveToHand(3); 
                    meld.removeDie(hand.getDieInstance(3)); 
                } 
            } 
            else if (userChoice.equals("E")) { 
                if (hand.isInMeld(4) == false) { 
                    hand.moveToMeld(4); 
                    meld.addDie(hand.getDieInstance(4)); 
                } 
                else { 
                    hand.moveToHand(4); 
                    meld.removeDie(hand.getDieInstance(4)); 
                } 
            } 
            else if (userChoice.equals("F")) { 
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
        } 
        Farkle.display(hand, meld, false); 
        scanner.close(); 
    } 
}
