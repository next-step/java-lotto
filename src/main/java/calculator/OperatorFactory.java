package calculator;

public class OperatorFactory {
    public static Operator create(String operator) {
        if (operator.equals("+")) {
            return new Plus();
        }
        if (operator.equals("-")) {
            return new Minus();
        }
        if (operator.equals("*")) {
            return new Multiply();
        }
        if (operator.equals("/")) {
            return new Divide();
        }
        throw new IllegalArgumentException("invalid operator");
    }
}
