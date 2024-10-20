package calculator.calculate;


import java.util.HashMap;
import java.util.Map;

public enum Arithmetic {

    ADD("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final String symbol;
    private final Operation operation;
    private final static Map<String, Arithmetic> operations = new HashMap<>();

    Arithmetic(final String symbol, Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    static {
        operations.put(ADD.getSymbol(), ADD);
        operations.put(MINUS.getSymbol(), MINUS);
        operations.put(MULTIPLY.getSymbol(), MULTIPLY);
        operations.put(DIVIDE.getSymbol(), DIVIDE);
    }

    public static Arithmetic fromSymbol(String symbol) {
        if (operations.containsKey(symbol)) {
            return operations.get(symbol);
        }
        throw new IllegalArgumentException("유효하지 않는 기호입니다.");
    }
}
