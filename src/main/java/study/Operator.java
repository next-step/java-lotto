package study;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {

    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a,b) -> a * b),
    DIVIDE("/", Integer::divideUnsigned);

    private final String value;
    private final BiFunction<Integer, Integer, Integer> operator;

    Operator(final String value, final BiFunction<Integer, Integer, Integer> operator) {
        this.value = value;
        this.operator = operator;
    }

    public int operate(int a, int b) {
        return operator.apply(a, b);
    }

    public static Operator of(final String symbol) {
        return Stream.of(values())
                .filter(v -> Objects.equals(v.value, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
