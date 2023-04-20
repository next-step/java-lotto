import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BasicOperator implements Operator {
    ADD("+") {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MUTIPLY("*") {
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public int apply(int x, int y) {
            validateOperand(y);
            return x / y;
        }
    };

    private final String symbol;
    private static final Map<String, BasicOperator> OPERATOR_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(BasicOperator::toString, Function.identity())));

    BasicOperator(String symbol) {
        this.symbol = symbol;
    }

    public static BasicOperator find(String symbol) {
        if (OPERATOR_MAP.containsKey(symbol)) {
            return OPERATOR_MAP.get(symbol);
        }
        throw new IllegalArgumentException("연산자를 찾을 수 없습니다.");
    }

    private static void validateOperand(int operand) {
        if (operand == 0)
            throw new IllegalArgumentException("나눗셈 할때 피연산자가 0이면 안됩니다.");
    }

    public static boolean hasOperator(String symbol) {
        return OPERATOR_MAP.containsKey(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

}
