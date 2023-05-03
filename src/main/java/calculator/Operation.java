package calculator;

import java.util.function.BiFunction;

public class Operation {
    private final BiFunction<Integer, Integer, Integer> operation;

    public Operation(BiFunction<Integer, Integer, Integer> operation) {
        this.operation = operation;
    }

    public int operate(int left, int right) {
        return operation.apply(left, right);
    }
}
