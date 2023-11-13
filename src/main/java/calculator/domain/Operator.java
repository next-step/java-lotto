package calculator.domain;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final IntBinaryOperator op;

    private final String symbol;

    Operator(String symbol, IntBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public int apply(int x, int y) {
        return op.applyAsInt(x, y);
    }

    public static Operator findByOperator(String inputSymbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(inputSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기호 입니다." + inputSymbol));
    }
}
