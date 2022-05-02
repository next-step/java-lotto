package stringcalculator;

public class StringExpression {
    private static final String EXPRESSION_DELIMITER = " ";
    private String expression;

    private StringExpression(String expression) {
        if(isBlank(expression)) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        this.expression = expression;
    }

    public static StringExpression from(String expression) {
        return new StringExpression(expression);
    }

    public String[] split() {
        return this.expression.split(EXPRESSION_DELIMITER);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
