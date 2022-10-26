package calculator.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLICATION("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private static final String NOT_FOUR_OPERATOR_MESSAGE = "사칙연산의 기호가 아닙니다.";
    private static final Map<String, Operation> OPERATION_BY_KEY;

    static {
        OPERATION_BY_KEY = Arrays.stream(values())
                .collect(toMap(Operation::getOperator, Function.identity()));
    }

    private final String operator;
    private final BinaryOperator<Integer> calculator;


    Operation(String operator, BinaryOperator<Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static BinaryOperator<Integer> calculate(String operator) {
        try {
            return OPERATION_BY_KEY.get(operator).calculator;
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_FOUR_OPERATOR_MESSAGE);
        }
    }

    private String getOperator() {
        return operator;
    }
}
