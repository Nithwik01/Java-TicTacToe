
import java.util.Scanner;

public class Game {

    private Board board;
    private Scanner sc;

    // Constructor
    public Game() {
        board = new Board();
        sc = new Scanner(System.in);
    }

    // Start the game
    public void start() {

        System.out.println("===== TIC TAC TOE =====");

        boolean win = false;

        for (int turn = 0; turn < 9; turn++) {

            // Switch players
            char player;

            if (turn % 2 == 0) {
                player = 'X';
            } else {
                player = 'O';
            }

            System.out.println("Player " + player + "'s turn");

            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Validate and place move
            if (!board.placeMove(row, col, player)) {
                System.out.println("Invalid or occupied cell! Try again.");
                turn--;
                continue;
            }

            // Display board
            board.displayBoard();

            // Check winner
            if (checkWinner(player)) {
                System.out.println("Player " + player + " wins!");
                win = true;
                break;
            }
        }

        // Check draw
        if (!win) {
            System.out.println("Match Draw!");
        }
    }

    // Check winning conditions
    private boolean checkWinner(char player) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {

            if (board.getCell(i, 0) == player &&
                board.getCell(i, 1) == player &&
                board.getCell(i, 2) == player) {
                return true;
            }

            if (board.getCell(0, i) == player &&
                board.getCell(1, i) == player &&
                board.getCell(2, i) == player) {
                return true;
            }
        }

        // First diagonal
        if (board.getCell(0, 0) == player &&
            board.getCell(1, 1) == player &&
            board.getCell(2, 2) == player) {
            return true;
        }

        // Second diagonal
        if (board.getCell(0, 2) == player &&
            board.getCell(1, 1) == player &&
            board.getCell(2, 0) == player) {
            return true;
        }

        return false;
    }
}
