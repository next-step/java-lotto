package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", CalculationLogic::add),
    SUBTRACT("-", CalculationLogic::subtract),
    MULTIPLY("*", CalculationLogic::multiply),
    DIVIDE("/", CalculationLogic::divide);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public int operate(int a, int b) {
        return operation.apply(a, b);
    }
}