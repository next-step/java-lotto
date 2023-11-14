public class MinusExpression implements CalculatorExpression{

    private final int left;
    private final int right;

    public MinusExpression(int left, int right) {
        this.left = left;
        this.right = right;
    }


    public int calculate() {
        return left - right;
    }
}
