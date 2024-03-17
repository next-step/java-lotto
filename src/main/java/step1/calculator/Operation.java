package step1.calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+", Integer::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> y == 0 ? 0 : x / y);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operation(String symbol, BiFunction<Integer, Integer, Integer> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public String getSymbol() {
        return symbol;
    }

    private static final String INVALID_OPERATOR = "유효하지 않은 연산자 입니다 : %s";
    private static final Map<String, Operation> OPERATION_MAP;

    static {
        OPERATION_MAP = Arrays.stream(values())
                .collect(toMap(Operation::getSymbol, e -> e));
    }

    public static Operation find(String symbol) {
        if (OPERATION_MAP.containsKey(symbol)) {
            return OPERATION_MAP.get(symbol);
        }

        throw new IllegalArgumentException(String.format(INVALID_OPERATOR, symbol));
    }

    public int apply(int operand1, int operand2) {
        return this.calculator.apply(operand1, operand2);
    }

}
