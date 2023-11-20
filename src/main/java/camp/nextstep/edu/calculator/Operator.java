package camp.nextstep.edu.calculator;

import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private static final Map<String, Operator> symbolToOperator
        = Stream.of(values()).collect(Collectors.toMap(Operator::symbol, e -> e));

    private final String symbol;
    private final IntBinaryOperator operationFunction;

    Operator(String symbol, IntBinaryOperator operationFunction) {
        this.symbol = symbol;
        this.operationFunction = operationFunction;
    }

    static Operator fromSymbol(String symbol) {
        if (!symbolToOperator.containsKey(symbol)) {
            throw new IllegalArgumentException("지원하지 않는 잘못된 연산자입니다.");
        }
        return symbolToOperator.get(symbol);
    }

    int operate(int left, int right) {
        return operationFunction.applyAsInt(left, right);
    }

    private String symbol() {
        return this.symbol;
    }
}
