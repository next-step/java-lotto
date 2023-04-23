package stringcalculator;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BinaryOperator<Integer> operation;

    private static final Map<String, Operator> OPERATOR_MAP = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Operator::getSymbol, o -> o)));

    private String getSymbol() {
        return symbol;
    }

    Operator(String symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator of(String symbol) {
        return Optional.ofNullable(OPERATOR_MAP.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(String.format("사칙 연산 기호가 아닙니다. input: %s", symbol)));
    }

    public int operate(int result, int input) {
        return operation.apply(result, input);
    }
}
