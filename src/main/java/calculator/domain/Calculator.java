package calculator.domain;

public class Calculator {
    private Calculator() {}

    public static Number run(Number a, Number b, Operator operator) {
        if (operator.equals(Operator.PLUS)) {
            return a.add(b);
        } else if (operator.equals(Operator.MINUS)) {
            return a.subtract(b);
        } else if (operator.equals(Operator.MULTIPLY)) {
            return a.multiply(b);
        } else if (operator.equals(Operator.DIVIDE)) {
            return a.divide(b);
        }
        throw new IllegalArgumentException();
    }
}
