package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    public final String symbol;
    public final BiFunction<Integer, Integer, Integer> formula;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> formula) {
        this.symbol = symbol;
        this.formula = formula;
    }

    public static Operator valueOfSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
