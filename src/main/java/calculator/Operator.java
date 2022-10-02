package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static boolean isOperator(String value) {
        return Arrays.stream(Operator.values()).anyMatch(operator -> operator.value.equals(value));
    }
}
