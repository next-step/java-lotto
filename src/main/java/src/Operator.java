package src;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    DIVIDE("/", (num1, num2) -> num1 / num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2);

    private final String symbol;
    private final BinaryOperator<Integer> expression;

    Operator(String symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator byString(String name) {
        return Arrays.stream(values()).filter(value -> value.symbol.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
