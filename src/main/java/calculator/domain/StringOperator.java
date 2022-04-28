package calculator.domain;

public class StringOperator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private final String operator;

    public StringOperator(String operator) {
        validateOperatorName(operator);
        this.operator = operator;
    }

    private void validateOperatorName(String operator) {
        if (operator.equals(PLUS) || operator.equals(MINUS) || operator.equals(MULTIPLY) || operator.equals(DIVIDE)) {
            return;
        }
        throw new IllegalArgumentException("올바르지 않은 연산기호입니다.");
    }

    public int calculate(int number1, int number2) {
        Operator operator = OperatorSelector.findOperator(this.operator);
        return operator.operate(number1, number2);
    }
}
