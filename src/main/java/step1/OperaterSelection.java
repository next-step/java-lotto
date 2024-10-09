package step1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class OperaterSelection {
    private static final Map<String, IntBinaryOperator> operaterMap = new HashMap<>();

    static {
        operaterMap.put("+", (a, b) -> a + b);
        operaterMap.put("-", (a, b) -> a - b);
        operaterMap.put("*", (a, b) -> a * b);
        operaterMap.put("/", (a, b) -> {
            if(b == 0)
                throw new ArithmeticException("Division by zero");
            return a / b;
        });
    }

    public static IntBinaryOperator selection(String s) {
        if (!operaterMap.containsKey(s)) {
            throw new IllegalArgumentException("잘못된 기호");
        }
        return operaterMap.get(s);
    }

}
