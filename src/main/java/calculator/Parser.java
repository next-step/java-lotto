package calculator;

public class Parser {

    public static final String SPLIT_REGEX = "\\s+";
    public static final String ERROR_INVALID_ORDER = "연산 순서가 바르지 않습니다";
    public static final String NUMBER_REGEX = "-?[0-9]+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";

    public static String[] parse(String input) {
        String[] tokens = split(input);
        validateLength(tokens);
        validateSequence(tokens);
        return tokens;
    }

    private static String[] split(String input) {
        return input.trim().split(SPLIT_REGEX);
    }

    private static void validateLength(String[] tokens) {
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException(ERROR_INVALID_ORDER);
        }
    }

    private static void validateSequence(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (invalidToken(tokens[i], i)) {
                throw new IllegalArgumentException(ERROR_INVALID_ORDER);
            }
        }
    }

    private static boolean invalidToken(String token, int i) {
        if (i % 2 == 0 && token.matches(NUMBER_REGEX)) return false;
        if (i % 2 != 0 && token.matches(OPERATOR_REGEX)) return false;
        return true;
    }
}