package calculator;

public class Expression {
    private static final String NEGATIVE_OPERATOR = "-";
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isEmptyOrNull() {
        return expression == null || expression.isEmpty();
    }

    public boolean isOneLetter() {
        return expression.length() == 1;
    }

    public void hasNegative() {
        if (expression.contains(NEGATIVE_OPERATOR)) {
            throw new RuntimeException("음수가 포함되어 있는지 확인해주세요.");
        }
    }

    @Override
    public String toString() {
        return expression;
    }
}
