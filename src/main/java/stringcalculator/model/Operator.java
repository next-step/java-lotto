package stringcalculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (i, j) -> i + j),
    MINUS("-", (i, j) -> i - j),
    MULTIPLY("*", (i, j) -> i * j),
    DIVISION("/", (i, j) -> i / j);

    String name;
    BiFunction<Integer, Integer, Integer> operation;

    Operator(String name, BiFunction<Integer, Integer, Integer> operation) {
        this.name = name;
        this.operation = operation;
    }

    public int apply(int i, int j) {
        return operation.apply(i, j);
    }

    static Operator from(String text) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.name.equals(text))
                .findFirst()
                .orElse(null);
    }

}
