package StringCalculator;

import java.util.List;

public class StringCalculator {
    public static final String INVALID_INPUT_MESSAGE = "잘못된 입력값 입니다.";
    private static final String DELIMITER = " ";

    public static int calculate(String input) {
        validateString(input);
        List<String> expressionParts = parseExpression(input);
        int result = parseInt(expressionParts.get(0));

        for (int currentIndex = 1; currentIndex < expressionParts.size(); currentIndex += 2) {
            Operator operator = Operator.findBySymbol(expressionParts.get(currentIndex));
            int number = parseInt(expressionParts.get(currentIndex + 1));
            result = operator.calculate(result, number);
        }
        return result;
    }

    private static void validateString(String token) {
        if (isBlank(token)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean isBlank(String token) {
        return token == null || token.isBlank();
    }

    private static List<String> parseExpression(String input) {
        return List.of(input.split(DELIMITER));
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
