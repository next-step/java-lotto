package util;

public class Parser {

    public static final String EXPRESSION_PARSE_REGEX = "\\s+";

    public static String[] parse(String input) {
        if (!isValidExpression(input)) {
            throw new IllegalArgumentException("유효하지 않은 수식입니다.");
        }
        return input.split(EXPRESSION_PARSE_REGEX);
    }

    private static boolean isValidExpression(String expression) {
        return expression != null && !expression.isBlank();
    }
}
