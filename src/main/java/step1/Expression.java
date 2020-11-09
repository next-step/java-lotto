package step1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static step1.ExpressionSeparator.DEFAULT_DELIMITER;
import static util.Preconditions.checkArgument;

public class Expression {
    public static final String TOKEN_MUST_BE_NUMBER = "token must be number";
    public static final Expression EMPTY_EXPRESSION = new Expression("0", DEFAULT_DELIMITER);
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String text;
    private final String delimiter;

    private Expression(final String text, final String delimiter) {
        this.delimiter = delimiter;
        this.text = text;
    }

    public static Expression of(final String expression) {
        if (StringUtils.isBlank(expression)) {
            return EMPTY_EXPRESSION;
        }

        final Matcher matcher = PATTERN.matcher(expression);
        if (matcher.find()) {
            return new Expression(matcher.group(2), matcher.group(1));
        }
        return new Expression(expression, DEFAULT_DELIMITER);
    }

    public String getText() {
        return text;
    }

    public boolean isEmpty() {
        return this == EMPTY_EXPRESSION;
    }

    public boolean hasSingleNumber() {
        return text.length() == 1;
    }

    public boolean isNotNeedCalculate() {
        if (isEmpty()) {
            return true;
        }
        return hasSingleNumber();
    }

    public int toNumber() {
        return Integer.parseInt(text);
    }

    public List<String> toTokens() {
        final List<String> tokens = ExpressionSeparator.split(this, delimiter);
        checkArgument(tokens.stream().allMatch(NumberFormatValidator::isValid), TOKEN_MUST_BE_NUMBER);
        return tokens;
    }
}
