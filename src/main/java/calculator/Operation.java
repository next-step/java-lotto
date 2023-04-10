package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntBinaryOperator;

public enum Operation {
    Plus("+", (x, y) -> x + y),
    Minus("-", (x, y) -> x - y),
    Multiply("*", (x, y) -> x * y),
    Divide("/", (x, y) -> x / y);

    private final String value;
    private final IntBinaryOperator operation;

    Operation(String value, IntBinaryOperator operation) {
        this.value = value;
        this.operation = operation;
    }

    public int applyAsInt(int left, int right) {
        return operation.applyAsInt(left, right);
    }

    static Operation toOperation(String value) {
        try {
            return Arrays.stream(values()).filter(
                    s -> Objects.equals(s.value, value)
            ).findFirst().get();
        } catch (Exception e) {
            throw new IllegalArgumentException("연산자 아닙니다.");
        }
    }

}
