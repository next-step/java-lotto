package stringCalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;


public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUX("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String sign;
    private final BiFunction<Integer, Integer, Integer> operation;

    public String sign() {
        return sign;
    }

    Operation(String sign, BiFunction<Integer, Integer, Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public static Operation findOperator(String sign) {
        return Arrays.stream(Operation.values())
                .filter(operation -> Objects.equals(operation.sign(), sign))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("input value is invalid operation symbol");
                });
    }

    public int apply(int x, int y) {
        return operation.apply(x, y);
    }
}
