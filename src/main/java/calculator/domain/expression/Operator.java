package calculator.domain.expression;

import java.util.Arrays;

public enum Operator {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.symbol().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid operator symbol"));
    }

    public static boolean isOperator(String operator) {
        return Arrays.stream(Operator.values())
                .anyMatch(o -> o.symbol().equals(operator));
    }

    public String symbol() {
        return operator;
    }

}
