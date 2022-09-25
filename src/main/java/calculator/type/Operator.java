package calculator.type;

import java.util.HashMap;
import java.util.Map;

public abstract class Operator {
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    private static final Map<String, Operator> CACHE = new HashMap<>();

    static {
        CACHE.put(ADD, new Add());
        CACHE.put(SUBTRACT, new Subtract());
        CACHE.put(MULTIPLY, new Multiply());
        CACHE.put(DIVIDE, new Divide());
    }

    public static Operator findOperator(String operator) {
        Operator result = CACHE.get(operator);
        if (result == null) {
            throw new IllegalArgumentException(operator + "은(는) 지원하지 않는 연산자입니다.");
        }
        return result;
    }

    public abstract int operate(int num1, int num2);
}
