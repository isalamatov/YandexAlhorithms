import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessNSaw {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] cells = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int columnCellCount = 0;
        int perimeter = 0;
        int intersectionCount = 0;

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int cellsCount = scanner.nextInt();
        for (int i = 0; i < cellsCount; i++) {
            cells[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (cells[i][j] == 1) {
                    columnCellCount++;
                    if (cells[i-1][j] == 1) intersectionCount++;
                    if (cells[i][j-1] == 1) intersectionCount++;
                }
            }

            if (columnCellCount != 0)
                perimeter = perimeter + columnCellCount * 4 - (intersectionCount) * 2;

            intersectionCount = 0;
            columnCellCount = 0;
        }
        System.out.println(perimeter);
    }
}

