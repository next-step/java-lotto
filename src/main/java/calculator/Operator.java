package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a,b) -> a * b),
    DIVIDE("/", (a,b) -> a / b);

    private final String op;
    private final BiFunction<Integer, Integer, Integer> calculateFunc;

    Operator(String op, BiFunction<Integer, Integer, Integer> calculateFunc) {
        this.op = op;
        this.calculateFunc = calculateFunc;
    }

    public Integer calculate(Integer a, Integer b) {
        return this.calculateFunc.apply(a, b);
    }

    public static Operator findOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.op != null)
                .filter(operator -> operator.op.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산이 잘못되었다."));
    }
}
