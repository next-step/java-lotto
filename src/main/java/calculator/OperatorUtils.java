package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class OperatorUtils {
    private static final Map<String, IntBinaryOperator> operaterMap = new HashMap<>();

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DEVIDE = "/";

    static {
        operaterMap.put(PLUS, (a, b) -> a + b);
        operaterMap.put(MINUS, (a, b) -> a - b);
        operaterMap.put(MULTIPLY, (a, b) -> a * b);
        operaterMap.put(DEVIDE, (a, b) -> {
            if(b == 0)
                throw new ArithmeticException(ErrorMessage.DIVISION_BY_ZERO.getMessage());
            return a / b;
        });
    }

    public static IntBinaryOperator selection(String s) {
        if (!operaterMap.containsKey(s)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR.getMessage());
        }
        return operaterMap.get(s);
    }

}
