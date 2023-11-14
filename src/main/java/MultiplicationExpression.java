public class MultiplicationExpression implements CalculatorExpression {

    private final CalculatorExpression left;
    private final CalculatorExpression right;

    public MultiplicationExpression(CalculatorExpression left, CalculatorExpression right) {
        this.left = left;
        this.right = right;
    }

    public int calculate() {
        return this.left.calculate() * this.right.calculate();
    }
}
