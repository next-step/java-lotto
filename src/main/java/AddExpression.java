public class AddExpression implements CalculatorExpression{

    private final int left;
    private final int right;

    public AddExpression(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int calculate() {
        return left + right;
    }
}
