public class MinusExpression implements CalculatorExpression{

    private final CalculatorExpression left;
    private final CalculatorExpression right;

    public MinusExpression(CalculatorExpression left, CalculatorExpression right) {
        this.left = left;
        this.right = right;
    }


    public int calculate() {
        return left.calculate() - right.calculate();
    }
}
