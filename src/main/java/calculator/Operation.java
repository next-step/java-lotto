package calculator;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

enum Operation {

    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    public final String operator;
    private final BinaryOperator<Integer> function;

    Operation(String operator, BinaryOperator<Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public int calculate(int a, int b) {
        return this.function.apply(a, b);
    }
}

