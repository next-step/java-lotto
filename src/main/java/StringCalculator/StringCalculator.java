package StringCalculator;

import java.util.List;

public class StringCalculator {
    public static final String INVALID_INPUT_MESSAGE = "잘못된 입력값 입니다.";
    public static final String INVALID_OPERATOR_MESSAGE = "사칙연산 기호가 아닙니다.";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private static final String DELIMITER = " ";
    private static final int OPERATOR_INDEX = 1;
    private static final int OPERATOR_INDEX_STEP_SIZE = 2;

    public static List<String> calculate(String input) {
        validateString(input);
        List<String> strings = List.of(input.split(DELIMITER));
        for (int index = OPERATOR_INDEX; index < strings.size(); index += OPERATOR_INDEX_STEP_SIZE) {
            validateToken(strings.get(index));
        }
        return strings;
    }

    private static void validateString(String token) {
        if (isBlank(token)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

    }

    private static boolean isBlank(String token) {
        return token == null || token.isBlank();
    }

    private static void validateToken(String token) {
        if (!isOperator(token)) {
            throw new IllegalArgumentException(INVALID_OPERATOR_MESSAGE);
        }
    }

    private static boolean isOperator(String token) {
        return token.matches(OPERATOR_PATTERN);
    }
}
