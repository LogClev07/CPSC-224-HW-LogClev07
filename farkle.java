public class Farkle {
    public static void display(Hand hand, Meld meld) {
        boolean finished = false;
        hand.rollDice();
        int[] handValueTotals = hand.getValueTotals();
        while (finished == false) {
            // Used ChatGPT to understand how to use printf
            // Also used ChatGPT to help adapt spacing from CPP example
            System.out.println("***************Let's Play Farkle!***************");
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
            System.out.println("(K) Bank Meld & End Round");
            System.out.println("(Q) Quit game");
            System.out.println();
            System.out.print("Enter letters for your choice(s): A,B,C,D,E,F,K,Q: ");
        }
    }
}
