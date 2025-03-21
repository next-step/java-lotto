import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    ADD("+") {
        @Override
        public int apply(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT("-") {
        @Override
        public int apply(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int num1, int num2) {
            if (num2 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            return num1 / num2;
        }
    };

    private final String symbol;
    private static final Map<String, Operator> SYMBOL_MAP = Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, op -> op));

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int apply(int num1, int num2);

    public static Operator fromSymbol(String symbol) {
        Operator operator = SYMBOL_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("Unknown operator: " + symbol);
        }
        return operator;
    }
}
