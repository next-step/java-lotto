package calculator.domain;

public class DivideExpression implements CalculatorExpression {
    private final VariableExpression dividend;
    private final VariableExpression divisor;

    public DivideExpression(VariableExpression left, VariableExpression right) {
        this.dividend = left;
        this.divisor = right;
    }
    public VariableExpression calculate() {
        int result = Math.round((float)dividend.value() / divisor.value());
        return new VariableExpression(Integer.toString(result));
    }
}
