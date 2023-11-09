package calculator.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final IntBinaryOperator operator;

    Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int apply(int x, int y) {
        return operator.applyAsInt(x, y);
    }

    public String getSymbol() {
        return symbol;
    }

    public static Optional<Operation> fromString(String symbol) {
        Map<String, Operation> stringToEnum = Stream.of(values())
                .collect(toMap(Operation::getSymbol, Function.identity()));

        return Optional.ofNullable(stringToEnum.get(symbol));
    }

}
