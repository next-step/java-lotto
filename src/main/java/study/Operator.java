package study;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),

    NONE("NONE");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator from(String value) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.value.equals(value))
                .findFirst()
                .orElse(NONE);
    }
}
