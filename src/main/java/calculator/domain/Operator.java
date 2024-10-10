package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATOR_MAP = new HashMap<>() {{
        put("+", (a, b) -> a + b);
        put("-", (a, b) -> a - b);
        put("*", (a, b) -> a * b);
        put("/", (a, b) -> a / b);
    }};

    public static BiFunction<Integer, Integer, Integer> operator(String operator) {
        return OPERATOR_MAP.get(operator);
    }
}
