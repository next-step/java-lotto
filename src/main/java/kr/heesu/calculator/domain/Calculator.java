package kr.heesu.calculator.domain;

public class Calculator {
    private final Expression expression;

    private Calculator(Expression expression) {
        this.expression = expression;
    }

    public static Calculator of(Expression expression) {
        return new Calculator(expression);
    }

    public void calculate() {
        expression.nextOperation();
    }

    public boolean hasNext() {
        return expression.hasNextArgument();
    }

    public Result getResult() {
        return expression.getResult();
    }
}
