import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Futurama {
    public static void main(String[] args) throws FileNotFoundException {
        final String PATH = "input.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);
        int quantity = scanner.nextInt();
        int swaps = scanner.nextInt();
        int[] a = new int[quantity + 1];
        a[0] = 0;
        int[] b = new int[swaps * 2];

        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + 1;
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < swaps*2; i = i + 2) {
            b[i] = scanner.nextInt();
            b[i+1] = scanner.nextInt();
            swap(b[i], b[i+1], a);
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        for (int i = 1; i < a.length - 2; i++) {
            if (a[i] != i) {
                int index = a[i];
                swap(i, a.length - 2, a);
                System.out.println(i + " " + (a.length - 2));
                swap(index, a.length - 1, a);
                System.out.println(index + " " + (a.length - 1));
                swap(i, a.length - 1, a);
                System.out.println(i + " " + (a.length - 1));
                swap(index, a.length - 2, a);
                System.out.println(index + " " + (a.length - 2));
            }
        }
        swap(a.length - 2, a.length - 1, a);
        System.out.println((a.length - 2) + " " + (a.length - 1));

        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println("\n");

    }

    public static void swap(int i, int j, int[] a) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
