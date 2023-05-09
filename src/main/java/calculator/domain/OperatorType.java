package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    MULTIPLE("*", Operand::multiple),
    DIVIDE("/", Operand::divide),
    EMPTY("기타", null);

    private final String symbol;
    private final BiFunction<Operand, Operand, Double> function;

    OperatorType(String symbol, BiFunction<Operand, Operand, Double> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public Double execute(Operand operand1, Operand operand2) {
        return function.apply(operand1, operand2);
    }

    public boolean hasSymbol(String symbol) {
        return Arrays.stream(OperatorType.values())
                .map(operatorType -> operatorType.symbol)
                .anyMatch(operatorType -> operatorType.equals(symbol));
    }
}
