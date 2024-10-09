package calculator.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");


    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static List<String> getOperators() {
        return Arrays.stream(Operator.values())
                .map(s -> s.operator)
                .collect(Collectors.toUnmodifiableList());
    }
}
