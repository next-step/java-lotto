package calculator.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern PATTERN = Pattern.compile("(?:[0-9]+\\s[-+/*]\\s)*[0-9]+");
    private static final String EXAMPLE_PATTERN = "2 + 3 * 4 / 2";

    public static void validateExpression(String expression) {

        if (isNullOrEmpty(expression)) {
            throw new IllegalArgumentException("연산식이 입력되지 않았습니다.");
        }

        if (isNotMatchPattern(expression)) {
            throw new IllegalArgumentException("입력값이 형식에 맞지 않습니다. ex) " + EXAMPLE_PATTERN);
        }
    }

    private static boolean isNotMatchPattern(String expression) {
        return !PATTERN.matcher(expression).matches();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isBlank();
    }
}
