package calculator.domain;

public class AddExpression implements CalculatorExpression {

    private final VariableExpression left;
    private final VariableExpression right;

    public AddExpression(VariableExpression left, VariableExpression right) {
        this.left = left;
        this.right = right;
    }

    public VariableExpression calculate() {
        int result = left.value() + right.value();
        return new VariableExpression(Character.forDigit(result, CalculatorExpression.RADIX));
    }
}
