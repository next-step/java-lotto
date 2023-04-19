public class Calculator {
    private final Operator operator;

    public static Calculator from(Operator operator) {
        return new Calculator(operator);
    }

    public Calculator(Operator operator) {
        this.operator = operator;
    }

    public int calculate(int a, int b) {
        return operator.calculate(a, b);
    }
}
