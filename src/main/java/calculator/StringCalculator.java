package calculator;

public class StringCalculator {

    private static final Calculation calculation = new Calculation();

    public int calculateExpression(StringExpression expression) {
        return calculation.calculate(expression);
    }

}
