package calculator;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    private static final Map<String, Operator> SYMBOL_OPERATOR_MAP = Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.symbol, operator -> operator));

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    public static Operator symbolToOperator(String symbol) {
        Operator operator = SYMBOL_OPERATOR_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
        }
        return operator;
    }
}
