import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ropes {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        int ropesNumber = scanner.nextInt();
        int maxLength = 0;
        int sumLength = 0;

        int[] ropesLength = new int[ropesNumber];

        for (int i = 0; i < ropesNumber; i++) {
            ropesLength[i] = scanner.nextInt();
            if (ropesLength[i] > maxLength) maxLength = ropesLength[i];
            sumLength += ropesLength[i];
        }
        if ((maxLength * 2 - sumLength)<=0) {
            System.out.println(sumLength);
        } else System.out.println((maxLength * 2 - sumLength));
    }
}
