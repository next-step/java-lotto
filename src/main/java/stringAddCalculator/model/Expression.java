package stringAddCalculator.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final String DEFAULT_STRING_DELIMITER = ",|:";
    private static final String DEFAULT_STRING_VALUE = "0";
    private static final int DELIMITER_MATCH_INDEX = 1;
    private static final int EXPRESSION_MATCH_INDEX = 2;

    private final String expression;

    private Expression(final String input) {
        this.expression = input;
    }

    public static Expression newInstance(final String input) {
        if (Objects.isNull(input) || "".equals(input.trim())) {
            return new Expression(DEFAULT_STRING_VALUE);
        }

        return new Expression(input);
    }

    public Numbers split() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.find()) {
            return splitWithCustomDelimiter(matcher);
        }

        return Numbers.create(expression.split(DEFAULT_STRING_DELIMITER));
    }

    private Numbers splitWithCustomDelimiter(final Matcher matcher) {
        String delimitersWithCustom = DEFAULT_STRING_DELIMITER + "|" + matcher.group(DELIMITER_MATCH_INDEX);
        String pureExpression = matcher.group(EXPRESSION_MATCH_INDEX);
        return Numbers.create(pureExpression.split(delimitersWithCustom));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
