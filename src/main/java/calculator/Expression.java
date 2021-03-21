package calculator;

public class Expression {
    private static final String NEGATIVE_OPERATOR = "-";
    private static final String DEFAULT = "0";
    private final String expression;

    public Expression(String expression) {
        this.expression = getDefaultOr(expression);
        checkNegative(this.expression);
    }

    private String getDefaultOr(String expression) {
        if (isEmptyOrNull(expression)) {
            return DEFAULT;
        }

        return expression;
    }

    public boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    public void checkNegative(String expression) {
        if (expression.contains(NEGATIVE_OPERATOR)) {
            throw new RuntimeException("음수가 포함되어 있는지 확인해주세요.");
        }
    }

    @Override
    public String toString() {
        return expression;
    }
}
