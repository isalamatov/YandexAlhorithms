public class StringYandex {
    public static void main(String[] args) {
        String[] input = {"Вероника Чехова физика — Безупречно", "Анна Строкова математика — Потрясающе", "Иван Петров геометрия — Безупречно"};
        System.out.println(serializeGrades(input));
    }

    public static String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    public static String serializeGrades(String[] grades) {
        String result = "";
        for (String str : grades) {
            StringBuilder sb = new StringBuilder(str);

            String[] split = str.replace("— ", "").split(" ");
            result = result + result.join(",", split[0], split[1], split[2], (gradeStringToInt(split[3]) + ";"));
        }

        return result;
    }

}

