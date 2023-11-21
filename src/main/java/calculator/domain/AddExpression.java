package calculator.domain;

public class AddExpression implements CalculatorExpression {

    private final Variable left;
    private final Variable right;

    public AddExpression(Variable left, Variable right) {
        this.left = left;
        this.right = right;
    }

    public Variable calculate() {
        int result = left.value() + right.value();
        return Variable.of(Integer.toString(result));
    }
}
