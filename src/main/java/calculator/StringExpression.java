package calculator;

public class StringExpression {

    public static final String DELIMITER = " ";
    public static final String INVALID_INPUT_NULL_OR_EMPTY = "null 혹은 공백 문자열은 연산 불가능합니다";

    private final String expression;

    StringExpression(String input) {
        validInput(input);
        this.expression = input;
    }

    private String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_NULL_OR_EMPTY);
        }
        return input;
    }

    public String[] getSplitedExpression() {
        return this.expression.split(DELIMITER);
    }

}
