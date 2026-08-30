import java.util.Scanner;

public class TicTacToeGame {

    static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void displayBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public static boolean checkWin(char player) {
        int[][] winningPositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int[] position : winningPositions) {
            if (board[position[0]] == player &&
                board[position[1]] == player &&
                board[position[2]] == player) {
                return true;
            }
        }

        return false;
    }

    public static boolean isDraw() {
        for (char cell : board) {
            if (cell >= '1' && cell <= '9') {
                return false;
            }
        }
        return true;
    }

    public static void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("=== Tic-Tac-Toe Game ===");

        while (playAgain) {

            resetBoard();
            char currentPlayer = 'X';

            for (int turn = 0; turn < 9; turn++) {

                displayBoard();

                System.out.print("Player " + currentPlayer + 
                                 ", enter your position (1-9): ");
                int position = sc.nextInt();

                if (position < 1 || position > 9 ||
                    board[position - 1] == 'X' ||
                    board[position - 1] == 'O') {

                    System.out.println("Invalid move! Try again.");
                    turn--;
                    continue;
                }

                board[position - 1] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}