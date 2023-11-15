package calculator.domain;

import calculator.exceptions.DivideByZeroException;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        validateDivideByZero(y);
        return x / y;
    });

    private static void validateDivideByZero(int y) {
        if (y == 0) {
            throw new DivideByZeroException();
        }
    }

    private static final Operator[] VALUES = values();

    private final IntBinaryOperator op;
    private final String symbol;

    Operator(String symbol, IntBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public int operate(int x, int y) {
        return op.applyAsInt(x, y);
    }

    public static Operator findByOperator(String inputSymbol) {
        return Arrays.stream(VALUES)
                .filter(operator -> operator.symbol.equals(inputSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기호 입니다." + inputSymbol));
    }
}
