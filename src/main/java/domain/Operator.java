package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operation, BiFunction<Integer, Integer, Integer> function) {
        this.operation = operation;
        this.function = function;
    }

    public static Operator of(String operation) {
        return Arrays.stream(values())
                .filter(operator -> operator.operation.equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다."));
    }

    public int calculate(int a, int b) {
        return function.apply(a, b);
    }
}

