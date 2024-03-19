package stringCalculator;

import java.util.Arrays;
import java.util.Objects;

interface Operator {
    int apply(int x, int y);
}

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUX("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String sign;
    private final Operator operator;

    public String sign() {
        return sign;
    }

    Operation(String sign, Operator operator) {
        this.sign = sign;
        this.operator = operator;
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
        return operator.apply(x, y);
    }
}
