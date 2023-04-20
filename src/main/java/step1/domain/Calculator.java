package step1.domain;

public class Calculator {
    private final Operator operator;

    public static Calculator from(Operator operator) {
        return new Calculator(operator);
    }

    private Calculator(Operator operator) {
        this.operator = operator;
    }

    public int calculate(int a, int b) {
        return operator.calculate(a, b);
    }
}
