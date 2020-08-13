package kr.heesu.calculator.domain;

import java.util.function.BiFunction;

public enum  Operator {
    ADD(Integer::sum);

    private final BiFunction<Integer, Integer, Integer> action;

    Operator(BiFunction<Integer, Integer, Integer> action) {
        this.action = action;
    }

    public static Operator of() {
        return ADD;
    }

    public int operate(int a, int b) {
        return action.apply(a, b);
    }
}
