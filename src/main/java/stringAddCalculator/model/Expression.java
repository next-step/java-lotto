package stringAddCalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final String DEFAULT_STRING_DELIMITER = ",|:";
    private static final int DELIMITER_MATCH_INDEX = 1;
    private static final int EXPRESSION_MATCH_INDEX = 2;

    private final String expression;

    private Expression(final String input) {
        this.expression = input;
    }

    public static Expression newInstance(String input) {
        if (input == null || "".equals(input.trim())) {
            return new Expression("0");
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

    private Numbers splitWithCustomDelimiter(Matcher matcher) {
        String delimitersWithCustom = DEFAULT_STRING_DELIMITER + "|" + matcher.group(DELIMITER_MATCH_INDEX);
        String pureExpression = matcher.group(EXPRESSION_MATCH_INDEX);
        return Numbers.create(pureExpression.split(delimitersWithCustom));
    }
}
