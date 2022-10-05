package calculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", Integer::sum),
    SUBTRACT("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

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
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public int calculate(int a, int b) {
        return function.apply(a, b);
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide(int a, int b){
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
