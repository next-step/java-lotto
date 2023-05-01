package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private final String notation;
    public final BiFunction<Integer, Integer, Integer> action;

    Operator(String notation, BiFunction<Integer, Integer, Integer> operate) {
        this.notation = notation;
        this.action = operate;
    }

    public static Operator fromNotation(String notation) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.notation.equals(notation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
