import java.util.HashMap;

public class HomeWork {
    public static void main(String[] args) {
        String str1 = "abccdeffff";
        String str2 = "ffffedccba";
        HashMap<Character, Integer> dictionary = new HashMap<>();

        if (str1.length() != str2.length()) {
            System.out.println("Не палиндром 1");
            return;
        } else {
            for (int i = 0; i < str1.toCharArray().length / 2 + 1; i++) {
                if (str1.toCharArray()[i] != str2.toCharArray()[str1.length() - 1 - i]) {
                    System.out.println("Не палиндром 1");
                    return;
                }
            }
        }
        System.out.println("Палиндром 1");

        StringBuilder stringBuilder = new StringBuilder(str1);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.toString().equals(str2));

        if (stringBuilder.toString().equalsIgnoreCase(str2)) {
            System.out.println("Палиндром 2");
        } else {
            System.out.println("Не палиндром 2");
        }

        for (char c : str1.toCharArray()) {
            dictionary.putIfAbsent(c, 0);
            dictionary.computeIfPresent(c, (k, v) -> v + 1);
        }
        System.out.println(dictionary);

        for (char c : str2.toCharArray()) {
            dictionary.computeIfPresent(c, (k, v) -> v - 1);
            dictionary.putIfAbsent(c, 0);

        }

        System.out.println(dictionary);

        for (Character c : dictionary.keySet()
        ) {
            if (dictionary.get(c) != 0) {
                System.out.println("No permutation");
                return;
            }
        }

        System.out.println("Permutation");
    }
}
