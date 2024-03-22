package calculator;

import java.util.List;

public class StringClassifier {
    private static final String DELIMITER = " ";
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";

    private StringClassifier() {
        throw new RuntimeException("유틸리티 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static List<String> split(String text) {
        return List.of(text.split(DELIMITER));
    }

    public static boolean isNumber(String str) {
        return str.matches(NUMBER_PATTERN);
    }

    public static boolean isOperator(String str) {
        return str.matches(OPERATOR_PATTERN);
    }
}
