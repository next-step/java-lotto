package calculator.domain;

public class MultiplicationExpression implements CalculatorExpression {

    private final VariableExpression left;
    private final VariableExpression right;

    public MultiplicationExpression(VariableExpression left, VariableExpression right) {
        this.left = left;
        this.right = right;
    }

    public VariableExpression calculate() {
        int result = left.value() * right.value();
        return new VariableExpression(Integer.toString(result));
    }
}
