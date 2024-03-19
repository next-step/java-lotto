package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        validateZero(y);
        return x / y;
    });

    private static final Operator[] VALUES = values();

    private static void validateZero(double num) {
        if (num == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    private final IntBinaryOperator operator;
    private final String symbol;

    Operator(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int operate(int x, int y) {
        return operator.applyAsInt(x, y);
    }

    public static Operator findByOperator(String inputSymbol) {
        return Arrays.stream(VALUES)
                .filter(operator -> operator.symbol.equals(inputSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호를 입력해주세요."));
    }

}
