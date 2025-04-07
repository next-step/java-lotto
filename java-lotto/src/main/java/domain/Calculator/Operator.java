package domain.Calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (a, b) -> a + b),

    SUBTRACT("-", (a, b) -> a - b),

    MULTIPLY("*", (a, b) -> a * b),

    DIVIDE("/", (a, b) -> {
        if (b == 0)
        {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operate;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public int operate(int first, int second) {
        return operate.apply(first, second);
    }

    public static Operator fromSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 연산자 입니다 : " + symbol));
    }

}
