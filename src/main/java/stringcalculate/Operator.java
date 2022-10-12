package stringcalculate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> (a + b)),
    SUBTRACT("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));
    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public String getOperator() {
        return operator;
    }

    public Integer calculate(Integer a, Integer b) {
        return biFunction.apply(a, b);
    }


}
