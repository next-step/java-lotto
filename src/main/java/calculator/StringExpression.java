package calculator;

public class StringExpression {

    public static final String DELIMITER = " ";

    private final String expression;

    StringExpression(String input) {
        validInput(input);
        this.expression = input;
    }

    private String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 혹은 공백 문자열은 연산 불가능합니다");
        }
        return input;
    }

    public String[] getSplitedExpression() {
        return this.expression.split(DELIMITER);
    }

}
