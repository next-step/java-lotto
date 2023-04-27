package step1;

public class StringCalculator {
    private final Expression expression;

    public StringCalculator(String[] expression) {
        this.expression = new Expression(expression);
    }

    public int calculate() {
        return expression.calculate();
    }

}
