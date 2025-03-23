package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", BigDecimal::add),
    SUBTRACTION("-", BigDecimal::subtract),
    MULTIPLICATION("*", BigDecimal::multiply),
    DIVISION("/", BigDecimal::divide);

    private final String symbol;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> expression;

    Operator(String symbol, BiFunction<BigDecimal, BigDecimal, BigDecimal> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        return expression.apply(a, b);
    }

    public static Operator find(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(it -> it.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbol + "은 유효하지 않은 연산자 입니다."));
    }
}
