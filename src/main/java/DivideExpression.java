public class DivideExpression implements CalculatorExpression{

    private final CalculatorExpression divisor;
    private final CalculatorExpression dividend;

    public DivideExpression(CalculatorExpression divisor, CalculatorExpression dividend) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    public int calculate() {
        return Math.round((float) dividend.calculate() / divisor.calculate());
    }
}
