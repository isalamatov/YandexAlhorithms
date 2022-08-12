import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Confuse {
    public static void main(String[] args) throws FileNotFoundException {
        final String PATH = "input.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);
        int quantity = scanner.nextInt();
        int confuseCount = scanner.nextInt();
        long[] b = new long[quantity];

        for (int i = 0; i < quantity; i++) {
            b[i] = scanner.nextLong();
        }

        long maxB = b[0];
        long minB = b[0];

        for (int i = 1; i < b.length; i++) {
            if (b[i] > maxB) {
                maxB = b[i];
            }
            if (b[i] < minB) {
                minB = b[i];
            }
        }
        System.out.println(maxB - minB);
    }
}