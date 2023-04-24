package step1;

public class StringCalculator {
    private final Expression expression;

    public StringCalculator(String[] expression) {
        if (expression.length < 3) {
            throw new IllegalArgumentException("형식에 맞춰 식을 입력하세요");
        }
        this.expression = new Expression(expression);
    }

    public int calculate() {
        return expression.calculate();
    }

}
