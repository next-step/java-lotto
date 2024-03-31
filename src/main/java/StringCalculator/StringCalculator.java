package StringCalculator;

public class StringCalculator {
    public static final String INVALID_INPUT_MESSAGE = "잘못된 입력값 입니다.";

    public static int calculate(String input) {
        validateString(input);
        return Expression.create(input).calculate();
    }

    private static void validateString(String token) {
        if (isBlank(token)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean isBlank(String token) {
        return token == null || token.isBlank();
    }
}
