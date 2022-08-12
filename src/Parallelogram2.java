import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parallelogram2 {
    public static void main(String[] args) throws IOException {
        final String PATH = "resources/input.txt";
        Double startTime = Double.valueOf(System.nanoTime());

        String str2 = Files.readString(Path.of(PATH));

        ArrayList<String> answers = Parallelogram2.parseInput(str2);

        String[] strings = str2.split("\r\n");
        Integer questionCount = Integer.parseInt(strings[0]);
        for (int i = 1; i <= questionCount; i++) {
            String[] substrings = strings[i].split(" ");
            if (!substrings[8].equals(answers.get(i-1))) System.out.println(strings[i]);
        }

        Double finishTime = Double.valueOf(System.nanoTime());
        Double duration = (finishTime - startTime) / 1000000000;
        System.out.printf("Time spent: %.2f", duration);
    }

    public static ArrayList<String> parseInput(String str) {
        ArrayList<String> answers = new ArrayList<>();
        String[] strings = str.split("\r\n");
        Integer questionCount = Integer.parseInt(strings[0]);
        for (int i = 1; i <= questionCount; i++) {
//            System.out.println(checkParallelogram(strings[i]));
            answers.add(checkParallelogram(strings[i]));
        }
        return answers;
    }

    public static String checkParallelogram(String string) {
        String[] strings = string.split(" ");
    //    if (strings.length != 8) return "NO";

        Point a = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        Point b = new Point(Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
        Point c = new Point(Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
        Point d = new Point(Integer.parseInt(strings[6]), Integer.parseInt(strings[7]));

        Vector ab = new Vector(a, b);
        Vector ac = new Vector(a, c);
        Vector ad = new Vector(a, d);
        Vector bc = new Vector(b, c);
        Vector bd = new Vector(b, d);
        Vector cd = new Vector(c, d);

        ArrayList<Vector> vectors = new ArrayList<>();
        vectors.add(ab);
        vectors.add(ac);
        vectors.add(ad);
        vectors.add(bc);
        vectors.add(bd);
        vectors.add(cd);

        for (int i = 0; i < vectors.size(); i++) {
            for (int j = i + 1; j < vectors.size(); j++) {
                if (Vector.isParallel(vectors.get(i), vectors.get(j)) &&
                        !Vector.isOnOneLine(vectors.get(i), vectors.get(j)) &&
                        vectors.get(i).length.equals(vectors.get(j).length)) return "YES";
            }
        }
        return "NO";
    }
}

class Point {
    Integer x;
    Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point p) {
        return ((this.x == p.x) && (this.y == p.y));
    }
}

class Vector {
    Point p1;
    Point p2;
    Integer length;
    Integer x;
    Integer y;

    public Vector(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.x = p1.x - p2.x;
        this.y = p1.y - p2.y;
        this.length = x * x + y * y;
    }

    public boolean equals(Vector vector) {
        return (this.p1.equals(vector.p1) && this.p2.equals(vector.p2))
                || (this.p1.equals(vector.p2) && this.p2.equals(vector.p1));
    }

    public static boolean isParallel(Vector vector1, Vector vector2) {
        return (Objects.equals(vector1.x * vector2.y, vector1.y * vector2.x));
    }

    public static boolean isOnOneLine(Vector vector1, Vector vector2) {
        Vector commonVector = new Vector(vector1.p1, vector2.p1);
        return isParallel(commonVector, vector1);
    }
}



