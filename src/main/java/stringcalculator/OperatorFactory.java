package stringcalculator;

public class OperatorFactory {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String MULTIPLE = "*";

    private OperatorFactory() {
        throw new AssertionError();
    }

    public static Operator get(String operator) {
        if (PLUS.equals(operator)) {
            return (a, b) -> a + b;
        }
        if (MINUS.equals(operator)) {
            return (a, b) -> a - b;
        }
        if (DIVIDE.equals(operator)) {
            return (a, b) -> a / b;
        }
        if (MULTIPLE.equals(operator)) {
            return (a, b) -> a * b;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다. : " + operator);
    }
}
