package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
    ;

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String sign, BiFunction<Integer, Integer, Integer> function) {
        this.sign = sign;
        this.function = function;
    }

    public static Operator findByName(String sign) {
        return Arrays.stream(values())
                .filter(type -> type.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public int operate(Number a, Number b) {
        return operate(a.value(), b.value());
    }

    public int operate(int a, int b) {
        return this.function.apply(a, b);
    }

}

