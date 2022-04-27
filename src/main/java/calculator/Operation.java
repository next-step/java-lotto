package calculator;

import java.util.function.BiFunction;

enum Operation {

    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    public final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operation(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public int calculate(int a, int b) {
        return this.function.apply(a, b);
    }
}

