package calculator.domain;

import calculator.error.ErrorMessage;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLICATION("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVISION("/", (leftOperand, rightOperand) -> {
        validDenominator(rightOperand);
        return leftOperand / rightOperand;
    }),
    SELF_MULTIPLICATION("", (leftOperand, rightOperand) -> leftOperand);

    private static final Map<String, Operator> separators;
    private static final int ZERO = 0;

    static {
        separators = Collections.unmodifiableMap(Stream.of(values())
                .collect(Collectors.toMap(Operator::getSeparator, Function.identity())));
    }

    private final String separator;
    private final BiFunction<Integer, Integer, Integer> calculation;

    Operator(String separator, BiFunction<Integer, Integer, Integer> calculation) {
        this.separator = separator;
        this.calculation = calculation;
    }

    public static Operator lookUp(String separator) {
        return Optional.ofNullable(separators.get(separator))
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_SUCH_OPERATOR.getErrorMessage()));
    }

    public static int calculate(Operator operator, int leftOperand, int rightOperand) {
        return operator.calculation.apply(leftOperand, rightOperand);
    }

    private static void validDenominator(int rightOperand) {
        if (rightOperand == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NO_DIVIDE_DENOMINATOR_ZERO.getErrorMessage());
        }
    }

    private String getSeparator() {
        return separator;
    }
}
