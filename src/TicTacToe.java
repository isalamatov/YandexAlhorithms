import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] board;
        int nX = 0;
        int nO = 0;
        int nV = 0;
        boolean wCX;
        boolean wCO;

        board = parseInput();
        nX = checkNumber(board, 1);
        nO = checkNumber(board, 2);
        nV = checkNumber(board, 0);

        if (!((nO == nX) || (nX == nO + 1))) {
            System.out.println("NO");
            return;
        }

        if ((nX + nO + nV) != 9) {
            System.out.println("NO");
            return;
        }

        wCX = checkWins(board, 1);
        wCO = checkWins(board, 2);

        if (wCX && nX <= nO) {
            System.out.println("NO");
            return;
        }

        if (wCO && nO < nX) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    public static int[][] parseInput() throws FileNotFoundException {
        int[][] board = new int[4][4];
        final String PATH = "input.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        return board;
    }

    public static int checkNumber(int[][] board, int number) {
        int counter = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board[i][j] == number) counter++;
            }
        }
        return counter;
    }

    public static boolean checkWins(int[][] board, int number) {
        boolean flag = false;

        if (board[1][1] == board[1][2] && board[1][2] == board[1][3] && board[1][3] == number) flag = true;
        if (board[2][1] == board[2][2] && board[2][2] == board[2][3] && board[2][3] == number) flag = true;
        if (board[3][1] == board[3][2] && board[3][2] == board[3][3] && board[3][3] == number) flag = true;
        if (board[1][1] == board[2][1] && board[2][1] == board[3][1] && board[3][1] == number) flag = true;
        if (board[1][2] == board[2][2] && board[2][2] == board[3][2] && board[3][2] == number) flag = true;
        if (board[1][3] == board[2][3] && board[2][3] == board[3][3] && board[3][3] == number) flag = true;
        if (board[1][1] == board[2][2] && board[2][2] == board[3][3] && board[3][3] == number) flag = true;
        if (board[3][1] == board[2][2] && board[2][2] == board[1][3] && board[1][3] == number) flag = true;

        return flag;
    }
}
