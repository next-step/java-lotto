package domain;

import static config.CalculatorExceptionMessage.DIVISOR_CANNOT_BE_ZERO;
import static config.CalculatorExceptionMessage.OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

    ADDITION("+", (addend, summand) -> addend + summand),
    SUBTRACTION("-", (minuend, subtrahend) -> minuend - subtrahend),
    MULTIPLICATION("*", (multiplicand, multiplier) -> multiplicand * multiplier),
    DIVISION("/", (dividend, divisor) -> {
        if (divisor == 0) {
            throw new IllegalArgumentException(DIVISOR_CANNOT_BE_ZERO.message());
        }

        return dividend / divisor;
    }),
    ;

    private static final Map<String, Operator> operatorContainer = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(Operator::symbol, Function.identity()));

    private final String symbol;
    private final BinaryOperator<Integer> calculation;

    Operator(final String symbol, final BinaryOperator<Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public String symbol() {
        return this.symbol;
    }

    public int calculate(final Operand leftOperand, final Operand rightOperand) {
        return calculation.apply(leftOperand.number(), rightOperand.number());
    }

    public static Operator from(final String symbol) {
        return Optional.ofNullable(operatorContainer.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(OPERATOR_SHOULD_BE_ARITHMETIC_SYMBOL.message(symbol)));
    }
}
