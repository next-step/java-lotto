import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator implements BinaryOperator<Operand> {

    PLUS("+") {
        @Override
        public Operand apply(final Operand left, final Operand right) {
            return left.plus(right);
        }
    },
    MINUS("-") {
        @Override
        public Operand apply(final Operand left, final Operand right) {
            return left.minus(right);
        }
    },
    TIMES("*") {
        @Override
        public Operand apply(final Operand left, final Operand right) {
            return left.times(right);
        }
    },
    DIVIDE("/") {
        @Override
        public Operand apply(final Operand left, final Operand right) {
            return left.divide(right);
        }
    };

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    private static final Map<String, Operator> stringToEnum =
        Stream.of(values())
            .collect(Collectors.toMap(Objects::toString, e -> e));

    public static Optional<Operator> fromString(final String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    @Override
    public String toString() {
        return symbol;
    }
}
