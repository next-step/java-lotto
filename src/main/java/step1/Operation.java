package step1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operation {
    PLUS("+", (v1, v2) -> v1 + v2),
    MINUS("-", (v1, v2) -> v1 - v2),
    MULTIPLY("*", (v1, v2) -> v1 * v2),
    DIVIDE("/", (v1, v2) -> v1 / v2);

    private final String sign;
    private final IntBinaryOperator operation;

    Operation(String sign, IntBinaryOperator operation) {
        this.sign = sign;
        this.operation = operation;
    }

    private static final Map<String, Operation> signMap =
            Arrays.stream(Operation.values())
                    .collect(Collectors.toMap(operation -> operation.sign, operation -> operation));

    public static Operation toOperation(String input) {
        checkIfNotMatched(input);
        return signMap.get(input);
    }

    private static void checkIfNotMatched(String input) {
        if (!signMap.containsKey(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public int operate(int v1, int v2) {
        return operation.applyAsInt(v1, v2);
    }
}
