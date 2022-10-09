package enums;

import java.util.Arrays;
import java.util.function.BiFunction;

import exception.NotAValidInputException;

public enum Operators {

    PLUS("+", (value1, value2) -> value1 + value2),
    MINUS("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> {
        if (value2 == 0)
            return 0;
        return value1 / value2;
    });

    private final String symbol;
    private BiFunction<Integer, Integer, Integer> operator;

    Operators(String symbol, BiFunction<Integer, Integer, Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public Integer operate(Integer value1, Integer value2) {
        return this.operator.apply(value1, value2);
    }

    public static Operators findOperator(String symbol) {
        return Arrays.stream(values())
            .filter(value -> value.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new NotAValidInputException("맞는 사칙 기호가 없습니다"));
    }
}
