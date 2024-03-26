package caculator.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;

public enum IntOperator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLE("*", (a, b) -> a * b);
    private final String operation;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    IntOperator(String operation,
                BiFunction<Integer, Integer, Integer> biFunction
    ) {
        this.operation = operation;
        this.biFunction = biFunction;
    }

    public int calculate(int a, int b){
        return biFunction.apply(a, b);
    }

    public static boolean isOperator(String value){
        return Arrays.stream(IntOperator.values())
                .anyMatch(it -> Objects.equals(it.operation, value));
    }

    public static IntOperator findOperationByValue(String value) {
        return Arrays.stream(IntOperator.values())
                .filter(it -> Objects.equals(it.operation, value))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
