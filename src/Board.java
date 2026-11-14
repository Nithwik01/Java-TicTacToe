
public class Board {

    private char[][] board;

    // Constructor
    public Board() {
        board = new char[3][3];

        // Initialize empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display board
    public void displayBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);

                if (j < 2) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    // Place player's symbol
    public boolean placeMove(int row, int col, char player) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    // Get a cell value
    public char getCell(int row, int col) {
        return board[row][col];
    }
}
