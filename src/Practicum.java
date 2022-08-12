import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Practicum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество участников: ");
        int playersNumber = scanner.nextInt();

        List<String> words = readWordsFromFile("words.txt");
        if (words.size() < playersNumber) {
            System.out.println("Недостаточно слов в файле. Добавьте слова и обновите файл.");
            return;
        }
        // если слов меньше, чем участников, то выведите сообщение:
        // "Недостаточно слов в файле. Добавьте слова и обновите файл."
        // и завершите выполнение программы
        Collections.shuffle(words);
        // воспользуйтесь статическим методом Collections.shuffle(List<?> list),
        // чтобы поменять порядок слов случайным образом

        int wordsNumber = words.size() / playersNumber;

        for (int i = 0; i < playersNumber; i++) {
            String filename = String.format("player%s.txt", i + 1);
            List<String> subList = words.subList(i * wordsNumber, (i + 1) * wordsNumber);
            writeListToFile(subList, filename);
        }

        System.out.println("Карточки готовы!");
    }

    private static List<String> readWordsFromFile(String filename) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8));
        ) {
            while (br.ready()) {
                result.add(br.readLine());
            }
            return result;
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время чтения файла.");
        }
        // добавьте построчное чтение из файла с помощью BufferedReader
        // в случае ошибки выведите сообщение: "Произошла ошибка во время чтения файла."
        return null;
    }

    private static void writeListToFile(List<String> list, String filename) {
        try (FileWriter fr = new FileWriter(filename, StandardCharsets.UTF_8);
        ) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                fr.write(iterator.next());
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время записи файла.");
        }
        // добавьте запись слов в файл с помощью FileWriter
        // в случае ошибки выведите сообщение: "Произошла ошибка во время записи файла."
    }
}