package calculator.domain;

public class DivideExpression implements CalculatorExpression {
    private final Variable dividend;
    private final Variable divisor;

    public DivideExpression(Variable left, Variable right) {
        this.dividend = left;
        this.divisor = right;
    }
    public Variable calculate() {
        int result = Math.round((float)dividend.value() / divisor.value());
        return Variable.of(Integer.toString(result));
    }
}
