package stringcalculator.enums;

import stringcalculator.domain.Number;
import stringcalculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", Number::add),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String symbol;
    private final BinaryOperator<Number> operation;

    Operator(String symbol, BinaryOperator<Number> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int operation(Number a, Number b) {
        return operation.apply(a, b).getValue();
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.symbol.equals(symbol))
                .findAny()
                .orElseThrow(InvalidOperatorException::new);
    }
}
