import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        int a;
        int b;
        int c;

        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        a = p / 3;
        b = (p - a) / 2;
        c = p - a - b;
        if ((a + b) <= c) {
            System.out.println("-1");
        } else {
            System.out.println(a + " " + b + " " + c);
            if (p % 2 != 0) {
                System.out.println("1 " + (p - 1) / 2 + " " + (p - 1) / 2);
            } else {
                System.out.println("2 " + (p - 2) / 2 + " " + (p - 2) / 2);
            }
        }
    }
}
