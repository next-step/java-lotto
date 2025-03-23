package calculator;

import java.util.regex.Pattern;

public class OperatorToken {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("^[+\\-*/]{1}$");
    public static final String INVALID_FORMAT_TEXT = "invalid format text : ";
    public static final String UNSUPPORTED_OPERATOR = "unsupported operator : ";

    private final String value;

    public OperatorToken(String input) {
        this.validate(input);
        this.value = input;
    }

    private void validate(String inputExpression) {
        if (inputExpression == null || !OPERATOR_PATTERN.matcher(inputExpression).matches()) {
            throw new IllegalArgumentException(INVALID_FORMAT_TEXT + inputExpression);
        }
    }

    public int apply(int left, int right) {
        if (value.equals("+")) return left + right;
        if (value.equals("-")) return left - right;
        if (value.equals("*")) return left * right;
        if (value.equals("/")) return left / right;
        throw new IllegalArgumentException(UNSUPPORTED_OPERATOR + value);
    }
}
