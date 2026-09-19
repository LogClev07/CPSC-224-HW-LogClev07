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
 
        playRound(hand, meld); 
    } 

    /**
     * Displays the current hand, meld, score, and optional menu.
     */
    public static void display(Hand hand, Meld meld, boolean showMenu) { 
        int[] handValueTotals = hand.getValueTotals(); 
 
        // Used ChatGPT to understand how to use printf 
        // Also used ChatGPT to help adapt spacing from CPP example 
        System.out.println("\n***************Let's Play Farkle!***************"); 
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
        System.out.printf("%16sMeld Score: %d%n", "", meld.calculateScore()); 
        System.out.println(); 
        if (showMenu == true) { 
            System.out.println("(K) Bank Meld & End Round"); 
            System.out.println("(Q) Quit game"); 
            System.out.println(); 
            System.out.print("Enter letter for your choice: A,B,C,D,E,F,K,Q: "); 
        } 
    } 
 
    /**
     * Plays a single round of Farkle.
     */
    public static void playRound(Hand hand, Meld meld) { 
        // Used ChatGPT to help learn Scanner class functionality 
        Scanner scanner = new Scanner(System.in); 
        boolean finished = false; 
        hand.rollDice(); 
        if (hand.detectFarkle() == true) {  
            System.out.println("You rolled a Farkle! Please try again.");  
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
