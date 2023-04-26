package calculator.operation;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum Operations {

    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private static final Map<String, Operations> symbol2Operations = stream(Operations.values())
            .collect(toMap(ops -> ops.symbol, ops -> ops));


    private final String symbol;
    private final Operation operation;

    Operations(String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }


    public static Operations of(String symbol) {
        if (symbol2Operations.containsKey(symbol)) {
            return symbol2Operations.get(symbol);
        }
        throw new IllegalArgumentException("invalid calculator.operation:" + symbol);
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public int apply(int x, int y) {
        return operation.apply(x, y);
    }
}
