package step1.domain;

import java.util.Arrays;

public enum Operator {

    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private String label;

    Operator(String label) {
        this.label = label;
    }

    public static Operator valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(label))
                .findAny()
                .orElseThrow();
    }

}
