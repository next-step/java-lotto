package calculator;

public class StringCalculator {
    public int calculate(String text) {
        Expression expression = Expression.from(text);
        return expression.value();
    }
}
