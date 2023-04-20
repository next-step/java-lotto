package domain;

import common.error.ErrorMessage;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

    ADDITION("+", Integer::sum),
    SUBTRACTION("-", null),
    MULTIPLICATION("*", null),
    DIVISION("/", null);

    private static final Map<String, Operator> separators;

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

    private String getSeparator() {
        return separator;
    }
}
