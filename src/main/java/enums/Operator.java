package enums;

import java.util.Arrays;
import java.util.function.BiFunction;

import domain.Operand;
import exception.InvalidInputException;

public enum Operator {

    PLUS("+", (value1, value2) -> Operand.from(value1 + value2)),
    MINUS("-", (value1, value2) -> Operand.from(value1 - value2)),
    MULTIPLY("*", (value1, value2) -> Operand.from(value1 * value2)),
    DIVIDE("/", (value1, value2) -> {
        if (value2 == 0)
            return Operand.from(0);
        return Operand.from(value1 / value2);
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Operand> operator;

    Operator(String symbol, BiFunction<Integer, Integer, Operand> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(values())
            .filter(value -> value.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new InvalidInputException("맞는 사칙 기호가 없습니다"));
    }

    public static boolean isOperator(String inputValue) {
        return Arrays
            .stream(values())
            .anyMatch(operator -> operator.symbol.equals(inputValue));
    }

    public Operand operate(int value1, int value2) {
        return this.operator.apply(value1, value2);
    }
}
