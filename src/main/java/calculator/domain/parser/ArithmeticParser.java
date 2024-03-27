package calculator.domain.parser;

import static calculator.config.CalculatorExceptionMessage.EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK;
import static calculator.config.CalculatorExceptionMessage.EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticParser implements Parser {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^\\d+(?:\\s[+\\-*/]\\s\\d+)*$");
    private static final String DELIMITER = " ";

    @Override
    public String[] parse(final String text) {
        validateTextIsNotNullAndBlank(text);

        final String expressionText = text.trim();
        validateTextMatchesExpressionPattern(expressionText);

        return expressionText.split(DELIMITER);
    }

    private void validateTextIsNotNullAndBlank(final String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK.message(text));
        }
    }

    private void validateTextMatchesExpressionPattern(final String text) {
        final Matcher matcher = EXPRESSION_PATTERN.matcher(text);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(text));
        }
    }
}
