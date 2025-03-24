package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right),

    MINUS("-", (left, right) -> left - right),

    MULTIPLY("*", (left, right) -> left * right),

    DIVIDE("/", (left, right) -> left / right);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public static Operator getOperatorBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isSameSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다. 입력된 연산자: " + symbol));
    }

    public int calculate(int left, int right) {
        return calculator.apply(left, right);
    }

    private boolean isSameSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
