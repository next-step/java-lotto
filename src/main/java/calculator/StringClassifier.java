package calculator;

import java.util.List;

public class StringClassifier {
    private static final String DELIMITER = " ";
    public static List<String> split(String text) {
        return List.of(text.split(DELIMITER));
    }
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isOperator(String str) {
        return str.matches("[+\\-*/]");
    }
}
