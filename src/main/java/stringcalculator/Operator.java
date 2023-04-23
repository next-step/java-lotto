package stringcalculator;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    MULTIPLY("*", Math::multiplyExact),
    DIVIDE("/", Math::floorDiv);

    private final String symbol;
    private final BinaryOperator<Integer> operation;

    private static final Map<String, Operator> OPERATORS = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Operator::getSymbol, Function.identity())));

    private String getSymbol() {
        return symbol;
    }

    Operator(String symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator of(String symbol) {
        return Optional.ofNullable(OPERATORS.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(String.format("사칙 연산 기호가 아닙니다. input: %s", symbol)));
    }

    public int operate(int x, int y) {
        return operation.apply(x, y);
    }
}
