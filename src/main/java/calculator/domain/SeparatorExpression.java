package calculator.domain;

import java.util.List;

public class SeparatorExpression {
    private static final String SEPARATOR = " ";
    private static final String NO_INPUT_MESSAGE = "입력값이 없습니다.";

    private SeparatorExpression() {
    }

    public static List<String> getOperations(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(NO_INPUT_MESSAGE);
        }
        return List.of(input.split(SEPARATOR));
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
