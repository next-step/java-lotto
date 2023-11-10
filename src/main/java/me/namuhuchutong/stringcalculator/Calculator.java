package me.namuhuchutong.stringcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operator;

    static {
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", Integer::sum);
        map.put("-", (left, right) -> left - right);
        map.put("*", (left, right) -> left * right);
        map.put("/", (left, right) -> left / right);
        operator = map;
    }

    public static int calculate(Expression expression) {
        BiFunction<Integer, Integer, Integer> function = operator.get(expression.getOperator());
        return function.apply(expression.getLeft(), expression.getRight());
    }
}
