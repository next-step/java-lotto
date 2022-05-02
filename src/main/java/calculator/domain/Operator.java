package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        if (number2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return number1 / number2;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operator;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator findOperatorFromSymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isEqualOperator(symbol))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 연산자입니다.");
                });
    }

    private boolean isEqualOperator(String symbol) {
        return this.symbol.equals(symbol);
    }

    public int calculate(int number1, int number2) {
        return operator.apply(number1, number2);
    }
}
