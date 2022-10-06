package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
    UNKNOWN(null, null);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public int operate(int a, int b) {
        return this.function.apply(a, b);
    }

    public static Operator findOperator(String op) {
        return Arrays.stream(Operator.values()).filter(type -> type.operator != null)
                .filter(type -> op.equals(type.operator))
                .findFirst().orElse(Operator.UNKNOWN);
    }
}
