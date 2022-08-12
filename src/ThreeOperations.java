import java.util.Stack;

public class ThreeOperations {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Stack<Character> stack = new Stack<>();

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                stack.push(a[i]);
                if (a[i] == b[i]) {
                    stack.pop();
                }
            }
        } else {
            if (b.length > a.length) {
                char[] swap = b;
                b = a;
                a = swap;
            }
            int j = 0;
            for (int i = 0; i < a.length; i++) {
                stack.push(a[i]);
                if (i >= b.length) {
                    continue;
                }
                if (a[i] == b[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        if (stack.size() > 1) {
            System.out.println("-");
        } else {
            System.out.println("+");
        }

    }
}
