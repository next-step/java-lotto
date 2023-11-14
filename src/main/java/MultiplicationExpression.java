public class MultiplicationExpression implements CalculatorExpression {

    private final int left;
    private final int right;

    public MultiplicationExpression(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int calculate() {
        return this.left * this.right;
    }
}
