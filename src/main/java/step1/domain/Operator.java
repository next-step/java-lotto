package step1.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (operand1, operand2) -> (operand1 - operand2)),
    MULTIPLY("*", (operand1, operand2) -> (operand1 * operand2)),
    DIVIDE("/", (operand1, operand2) -> (Math.round(operand1 / operand2))),
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public int calculate(int operand1, int operand2) {
        return calculation.apply(operand1, operand2);
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
