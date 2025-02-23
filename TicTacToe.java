import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;
        boolean gameRunning = true;

        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + " - Enter a position (1-9): ");
            int position = scanner.nextInt();

            if (makeMove(position)) {
                moves++;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameRunning = false;
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameRunning = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean makeMove(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        if (position < 1 || position > 9 || board[row][col] == 'X' || board[row][col] == 'O') {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true; // Rows
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true; // Columns
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) || 
               (board[0][2] == board[1][1] && board[1][1] == board[2][0]); // Diagonals
    }
}

