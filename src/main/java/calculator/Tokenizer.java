package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final int GROUP_DELIMITER = 1;
    private static final int GROUP_EXPRESSION = 2;
    private static final String TOKEN_DELIMITER = ":|,";
    private static final String UNAVAILABLE_DELIMITER = "-";
    private static final String EXPRESSION_REGEX = "//(.)\\n(.*)";
    private static final String MESSAGE_NON_USABLE_SPLITTER = "사용할 수 없는 구분자입니다.";
    private static final Pattern pattern = Pattern.compile(EXPRESSION_REGEX);

    private Tokenizer() {}

    public static String[] splitExpression(String expression) {
        Matcher matcher = pattern.matcher(expression);
        String delimiter = TOKEN_DELIMITER;

        if (matcher.find()) {
            delimiter = matcher.group(GROUP_DELIMITER);
            expression = matcher.group(GROUP_EXPRESSION);
        }

        validateDelimiter(delimiter);

        return expression.split(delimiter);
    }

    private static void validateDelimiter(final String delimiter) {
        if (UNAVAILABLE_DELIMITER.equals(delimiter) || isInteger(delimiter)) {
            throw new RuntimeException(MESSAGE_NON_USABLE_SPLITTER);
        }
    }

    private static boolean isInteger(final String delimiter) {
        try {
            Integer.parseInt(delimiter);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
