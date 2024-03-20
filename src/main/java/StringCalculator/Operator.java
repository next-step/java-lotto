package StringCalculator;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    DIVIDE("/", (x, y) -> x / y),
    MULTIPLY("*", (x, y) -> x * y);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator findOperation(String symbol) {
        return Stream.of(values()).filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int x, int y) {
        return operation.apply(x, y);
    }
}
