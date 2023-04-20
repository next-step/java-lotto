package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operand {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String separator;

    private static final Map<String, Operand> separators;

    static {
        separators = Collections.unmodifiableMap(Stream.of(values())
                .collect(Collectors.toMap(Operand::getSeparator, Function.identity())));
    }

    Operand(String separator) {
        this.separator = separator;
    }

    public static Operand lookUp(String separator) {
        return Optional.ofNullable(separators.get(separator)).get();
    }

    public String getSeparator() {
        return separator;
    }
}
