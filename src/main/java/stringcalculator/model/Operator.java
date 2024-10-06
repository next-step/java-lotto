package stringcalculator.model;

import java.util.function.BiFunction;

public enum Operator {
    SUM((left, right) -> left + right),
    SUBTRACT((left, right) -> left - right),
    MULTIPLY((left, right) -> left * right),
    DIVIDE((left, right) -> left / right);

    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(BiFunction<Integer, Integer, Integer> calculate) {
        this.calculate = calculate;
    }

    public int calculate(int left, int right) {
        return calculate.apply(left, right);
    }
}
