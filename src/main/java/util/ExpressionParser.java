package util;

import static config.CalculatorExceptionMessage.INPUT_EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK;
import static config.CalculatorExceptionMessage.INPUT_EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExpressionParser {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^\\d+(?:\\s[+\\-*/]\\s\\d+)*$");
    private static final String DELIMITER = " ";

    private ExpressionParser() {
    }

    public static String[] parseToTokens(final String text) {
        validateTextIsNotNullAndBlank(text);

        final String expressionText = text.trim();
        validateTextMatchesExpressionPattern(expressionText);

        return expressionText.split(DELIMITER);
    }

    private static void validateTextIsNotNullAndBlank(final String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(INPUT_EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK.message(text));
        }
    }

    private static void validateTextMatchesExpressionPattern(final String text) {
        final Matcher matcher = EXPRESSION_PATTERN.matcher(text);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(text));
        }
    }
}
