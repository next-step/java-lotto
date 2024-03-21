package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private String display;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String display, BiFunction<Integer, Integer, Integer> expression) {
        this.display = display;
        this.expression = expression;
    }

    public String getDisplay() {
        return display;
    }

    public int calculate(int a, int b) {
        return this.expression.apply(a, b);
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(Operator.values())
            .filter(value -> value.getDisplay().equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 존재하지 않은 사칙연산자 입니다.", operator)));
    }
}
