package calculator;

public class Expression {
    private static final String NEGATIVE_OPERATOR = "-";
    private final String expression;

    public Expression(String expression) {
        if (isEmptyOrNull(expression)) {
            this.expression = "0";
            return;
        }

        checkNegative(expression);
        this.expression = expression;
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
