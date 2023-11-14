public class DivideExpression {

    private final int divisor;
    private final int dividend;

    public DivideExpression(int divisor, int dividend) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    public int calculate() {
        return Math.round((float) dividend / divisor);
    }
}
