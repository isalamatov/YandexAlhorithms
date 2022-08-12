public class Equation {
    public static void equation(String str) {
        String[] characters = str.split("\r\n");
        int a = Integer.parseInt(characters[0]);
        int b = Integer.parseInt(characters[1]);
        int c = Integer.parseInt(characters[2]);
        int d = Integer.parseInt(characters[3]);
        // System.out.println(a + " " + b + " " + c + " " + d);
        //     Решить в целых числах уравнение ( ax + b ) : ( cx + d ) = 0
        if (a == 0 && (c != 0 || d != 0)) {
            System.out.println("INF");
        } else if (c == 0 && d == 0) {
            System.out.println("NO");
        } else if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            System.out.println("NO");
        } else {
            int x = -b / a;
            System.out.println(x);
        }
    }
}
