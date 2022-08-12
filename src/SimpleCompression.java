import java.util.Stack;

public class SimpleCompression {
    public static void main(String[] args) {
        String str = "aa";
        Stack<Character> stack = new Stack<>();
        Character prevChar = str.toCharArray()[0];
        char[] chars = str.toCharArray();
        int counter = 1;
        String result = "";

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prevChar) {
                counter++;
            } else {
                if (counter != 1) {
                    result += counter;
                }
                counter = 1;
                result += prevChar;
            }
            prevChar = chars[i];
        }

        if (counter != 1) {
            result += counter;
        }

        result += prevChar;
        System.out.println(result);
    }

}
