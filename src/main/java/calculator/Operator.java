package calculator;

import java.util.Map;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        validateDivision(b);
        return a / b;
    });

    private final String symbol;
    private final ToIntBiFunction<Integer, Integer> operation;

    private static final Map<String, Operator> SYMBOL_OPERATOR_MAP = Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.symbol, operator -> operator));

    Operator(String symbol, ToIntBiFunction<Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int apply(int a, int b) {
        return operation.applyAsInt(a, b);
    }

    public static Operator symbolToOperator(String symbol) {
        Operator operator = SYMBOL_OPERATOR_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
        }
        return operator;
    }

    private static void validateDivision(int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }
}
