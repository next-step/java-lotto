import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator implements IntBinaryOperator {

    PLUS("+") {
        @Override
        public int applyAsInt(final int left, final int right) {
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public int applyAsInt(final int left, final int right) {
            return left - right;
        }
    },
    TIMES("*") {
        @Override
        public int applyAsInt(final int left, final int right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public int applyAsInt(final int left, final int right) {
            return left / right;
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

    public static boolean isOperator(final String symbol) {
        final Optional<Operator> op = fromString(symbol);
        return op.isPresent();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
