package kr.heesu.calculator.domain;

public class Calculator {
    private final Expression expression;
    private final Result result;

    private Calculator(Expression expression) {
        this.expression = expression;
        this.result = Result.of();
    }

    public static Calculator of(Expression expression) {
        return new Calculator(expression);
    }

    public void calculate() {
        int operand = expression.nextArgument();
        Operator operator = expression.getOperator();

        result.next(operand, operator);
    }

    public boolean hasNext() {
        return expression.hasNextArgument();
    }

    public Result getResult() {
        return result;
    }
}
