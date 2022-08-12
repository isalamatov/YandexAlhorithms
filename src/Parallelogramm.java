/*
import java.util.ArrayList;

public class Parallelogramm {
    public static void parseInput(String str) {
        String[] strings = str.split("\r\n");
        Integer questionCount = Integer.parseInt(strings[0]);
        if (questionCount >= strings.length) questionCount = strings.length;
        for (int i = 1; i <= questionCount; i++) {
            if (strings[i].equals("")) {
                System.out.println("NO");
                continue;
            }
            System.out.println(checkParallelogram(strings[i]));
        }
    }

    public static String checkParallelogram(String string) {
        String[] strings = string.split(" ");
        if (strings.length != 8) return "NO";
        Point a = new Point(Double.parseDouble(strings[0]), Double.parseDouble(strings[1]));
        Point b = new Point(Double.parseDouble(strings[2]), Double.parseDouble(strings[3]));
        Point c = new Point(Double.parseDouble(strings[4]), Double.parseDouble(strings[5]));
        Point d = new Point(Double.parseDouble(strings[6]), Double.parseDouble(strings[7]));
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
        ArrayList<EqualVectorsPair> pairs = new ArrayList<>();

        for (int i = 0; i < vectors.size(); i++) {
            double xSize = vectors.get(i).p1.x - vectors.get(i).p2.x;
            double ySize = vectors.get(i).p1.y - vectors.get(i).p2.y;
            double vectorLength = xSize * xSize + ySize * ySize;
            for (int j = i+1; j < vectors.size(); j++) {
                if (!vectors.get(i).equals(vectors.get(j))) {
                    double xSize2 = vectors.get(j).p1.x - vectors.get(j).p2.x;
                    double ySize2 = vectors.get(j).p1.y - vectors.get(j).p2.y;
                    double vectorLength2 = xSize2 * xSize2 + ySize2 * ySize2;
                    if (vectorLength == vectorLength2) {
                        EqualVectorsPair equalVectorsPair = new EqualVectorsPair(vectors.get(i), vectors.get(j));
                        EqualVectorsPair reverseEqualVectorsPair = new EqualVectorsPair(vectors.get(j), vectors.get(i));
                        pairs.add(equalVectorsPair);
                    }
                }
            }
        }
        if (pairs.size() >= 2) {
            for (EqualVectorsPair pair : pairs) {
                if ((pair.v1.p1.x == pair.v2.p1.x) && (pair.v1.p1.y == pair.v2.p1.y)) continue;
                if ((pair.v1.p2.x == pair.v2.p2.x) && (pair.v1.p2.y == pair.v2.p2.y)) continue;
                double v1X = pair.v1.p1.x - pair.v1.p2.x;
                double v2X = pair.v2.p1.x - pair.v2.p2.x;
                double v1Y = pair.v1.p1.y - pair.v1.p2.y;
                double v2Y = pair.v2.p1.y - pair.v2.p2.y;
                System.out.println(" v1X = " + v1X + " v2X = " + v2X + " v1Y = " + v1Y + " v2Y = " + v2Y);
                if ((v1X == 0 && v1Y == 0) || (v2X == 0 && v2Y == 0)) return "NO";
                if ((v1X == 0 && v2X == 0) || (v1Y == 0 & v2Y == 0)) return "YES";
                if ((v1X != 0 && v2X == 0) || (v1Y != 0 & v2Y == 0)) continue;
                if (v1X / v2X == v1Y / v2Y) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Vector {
    Point p1;
    Point p2;

    public Vector(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}

class EqualVectorsPair {
    Vector v1;
    Vector v2;

    public EqualVectorsPair(Vector v1, Vector v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}*/
