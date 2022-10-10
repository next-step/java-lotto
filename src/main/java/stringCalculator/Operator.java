package stringCalculator;

import java.util.Arrays;
import java.util.List;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
