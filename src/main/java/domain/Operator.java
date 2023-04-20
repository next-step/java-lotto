package domain;

import common.error.ErrorMessage;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String separator;

    private static final Map<String, Operator> separators;

    static {
        separators = Collections.unmodifiableMap(Stream.of(values())
                .collect(Collectors.toMap(Operator::getSeparator, Function.identity())));
    }

    Operator(String separator) {
        this.separator = separator;
    }

    public static Operator lookUp(String separator) {
        return Optional.ofNullable(separators.get(separator))
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_SUCH_OPERATOR.getErrorMessage()));
    }

    private String getSeparator() {
        return separator;
    }
}
