package StringCalculator;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static int operating(int value1, String operation, int value2) {
        if (Operation.PLUS.getValue().equals(operation))
            return plus(value1, value2);

        if (Operation.MINUS.getValue().equals(operation))
            return minus(value1, value2);

        if (Operation.MULTIPLY.getValue().equals(operation))
            return multiply(value1, value2);

        if (Operation.DIVIDE.getValue().equals(operation))
            return divide(value1, value2);

        throw new IllegalArgumentException();
    }

    private static int plus(int value1, int value2) {
        return value1 + value2;
    }

    private static int minus(int value1, int value2) {
        return value1 - value2;
    }

    private static int multiply(int value1, int value2) {
        return value1 * value2;
    }

    private static int divide(int value1, int value2) {
        return value1 / value2;
    }
}
