import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getMove(input, "Player A");
            String playerB = getMove(input, "Player B");

            System.out.println();
            System.out.println("Player A chose: " + fullMove(playerA));
            System.out.println("Player B chose: " + fullMove(playerB));
            System.out.println();

            determineWinner(playerA, playerB);

            System.out.print("\nPlay again? [Y/N]: ");
            playAgain = input.nextLine().trim();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("\nThanks for playing!");
        input.close();
    }

    private static String getMove(Scanner input, String playerName) {
        String move;
        while (true) {
            System.out.print(playerName + " - enter move (R, P, S): ");
            move = input.nextLine().trim();

            if (move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S")) {
                return move.toUpperCase();
            } else {
                System.out.println("Invalid input. Please enter R, P, or S.\n");
            }
        }
    }

    private static String fullMove(String move) {
        switch (move.toUpperCase()) {
            case "R": return "Rock";
            case "P": return "Paper";
            case "S": return "Scissors";
            default: return "";
        }
    }

    private static void determineWinner(String a, String b) {
        if (a.equals(b)) {
            System.out.println(fullMove(a) + " vs " + fullMove(b) + " — it's a Tie!");
        } else if ((a.equals("R") && b.equals("S")) ||
                (a.equals("P") && b.equals("R")) ||
                (a.equals("S") && b.equals("P"))) {
            printWinMessage(a, b, "Player A wins!");
        } else {
            printWinMessage(b, a, "Player B wins!");
        }
    }

    private static void printWinMessage(String winner, String loser, String result) {
        if (winner.equals("R") && loser.equals("S")) {
            System.out.println("Rock breaks Scissors — " + result);
        } else if (winner.equals("P") && loser.equals("R")) {
            System.out.println("Paper covers Rock — " + result);
        } else if (winner.equals("S") && loser.equals("P")) {
            System.out.println("Scissors cuts Paper — " + result);
        }
    }
}
