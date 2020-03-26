package stringAddCalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String DEFAULT_STRING_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int DELIMITER_MATCH_INDEX = 1;
    private static final int EXPRESSION_MATCH_INDEX = 2;

    private final String expression;
    private final String delimiters;

    private Expression(final String input, final String delimiters) {
        this.expression = input;
        this.delimiters = delimiters;
    }

    public static Expression newInstance(String input) {
        if (input == null || "".equals(input.trim())) {
            return new Expression("0", DEFAULT_STRING_DELIMITER);
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = DEFAULT_STRING_DELIMITER + "|" + matcher.group(DELIMITER_MATCH_INDEX);
            String remainInput = matcher.group(EXPRESSION_MATCH_INDEX);
            return new Expression(remainInput, customDelimiter);
        }
        return new Expression(input, DEFAULT_STRING_DELIMITER);
    }

    public String[] split() {
        return expression.split(delimiters);
    }
}
