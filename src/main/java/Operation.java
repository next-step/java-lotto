import java.util.HashMap;
import java.util.Map;

public enum Operation {
    PLUS("+") {
        public int apply(int x, int y) {
            return x+y;
        }
    },
    MINUS("-") {
        public int apply(int x, int y) {
            return x-y;
        }
    },
    TIMES("*") {
        public int apply(int x, int y) {
            return x*y;
        }
    },
    DIVIDE("/") {
        public int apply(int x, int y) {
            return x/y;
        }
    };

    private static final Map<String, Operation> BY_SYMBOL = new HashMap<>();

    static {
        for (Operation operation : values()) {
            BY_SYMBOL.put(operation.symbol, operation);
        }
    }

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation valueOfSymbol(String symbol) {
        Operation operation = BY_SYMBOL.get(symbol);
        if (operation == null) throw new IllegalArgumentException();
        return operation;
    }

    public abstract int apply(int x, int y);

}
