package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    ADD_OPERATOR("+"),
    SUBTRACT_OPERATOR("-"),
    MULTIPLY_OPERATOR("*"),
    DIVIDE_OPERATOR("/");

    private final static String ILLEGAL_OPERATOR_EXCEPTION = "잘못된 사칙연산 기호입니다.";

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operatorString) {
        return Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operatorString))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ILLEGAL_OPERATOR_EXCEPTION));
    }

    public static List<String> parseOperators(List<String> inputs) {
        return inputs.stream()
                .filter(input -> !Digit.isDigit(input))
                .collect(Collectors.toList());
    }
}
