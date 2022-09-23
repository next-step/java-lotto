package calculator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OperatorFactory {
    private static final Map<String, Operator> CACHE = new ConcurrentHashMap<>();

    static {
        CACHE.put("+", new Add());
        CACHE.put("-", new Subtract());
        CACHE.put("*", new Multiply());
        CACHE.put("/", new Divide());
    }

    private OperatorFactory() {
    }

    public static Operator findOperator(String operator) {
        Operator result = CACHE.get(operator);
        if (result == null) {
            throw new IllegalArgumentException(operator + "은(는) 지원하지 않는 연산자입니다.");
        }

        return result;
    }
}
