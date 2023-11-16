package calculator.domain;

public class MinusExpression implements CalculatorExpression {

    private final VariableExpression left;
    private final VariableExpression right;

    public MinusExpression(VariableExpression left, VariableExpression right) {
        this.left = left;
        this.right = right;
    }

    public VariableExpression calculate() {
        int result = left.value() - right.value();
        return VariableExpression.of(Integer.toString(result));
    }
}
