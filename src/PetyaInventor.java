import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PetyaInventor {
    public static void main(String[] args) throws FileNotFoundException {
        final String PATH = "input.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);
        String stampString = scanner.nextLine();
        String resultString = scanner.nextLine();
        char[] stamp = stampString.toCharArray();
        char[] result = resultString.toCharArray();
        int j = stamp.length - 1;
        boolean flag = false;
        int lastIndex = -1;

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == stamp[j]) {
                flag = true;
                if (i > lastIndex) {
                    lastIndex = i;
                }
                if (j > 0) {
                    j--;
                } else {
                    j = stamp.length - 1;
                }
            } else {
                flag = false;
                lastIndex = -1;
                j = stamp.length - 1;
            }
        }
        if (flag && (lastIndex != (result.length - 1))) {
            System.out.println(resultString.substring(lastIndex+1));
        } else if (flag){
            System.out.println("");
        } else {
            System.out.println(result);
        }

    }
}
