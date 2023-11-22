package stringCalculator.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private final String operator;

    private static final Map<String, Operator> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, Function.identity()));

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int apply(int x, int y);

    public static Optional<Operator> fromString(String operator) {
        return Optional.ofNullable(stringToEnum.get(operator));

    }

    @Override
    public String toString() {
        return this.operator;
    }
}
