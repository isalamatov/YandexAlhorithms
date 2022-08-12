import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OccurrenceCount {

    public static void occurrenceCount(String str2) {
        char[] chars = str2.toCharArray();
        List<Character> dict = new ArrayList<>();
        HashMap<Character, Integer> dictionary = new HashMap<>();
        int counter = 0;
        Character maxChar = null;
        int maxOccurrence = 0;


//        for (char c : chars) {
//            if (dictionary.containsKey(c)) {
//                dictionary.put(c, dictionary.get(c) + 1);
//                if (dictionary.get(c) > maxOccurrence) {
//                    maxOccurrence = dictionary.get(c);
//                    maxChar = c;
//                }
//            } else {
//                dictionary.put(c, 1);
//            }
//        }

        for (char c1 : chars) {
            if (!dict.contains(c1)) {
                for (char c2 : chars
                ) {
                    if (c1 == c2) {
                        counter++;
                    }
                }
                if (counter > maxOccurrence) {
                    maxOccurrence = counter;
                    maxChar = c1;
                }
                dict.add(c1);
            }
            counter = 0;
        }
        System.out.printf("Max symbol is %s, occurrence %s \n", maxChar, maxOccurrence);
    }
}
