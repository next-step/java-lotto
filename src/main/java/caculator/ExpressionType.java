package caculator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ExpressionType {
    ADDITION("+", (a, b) -> (a + b)),
    SUBTRACTION("-", (a, b) -> (a - b)),
    MULTIPLICATION("*", (a, b) -> (a * b)),
    DIVISION("/", (a, b) -> (a / b));

    private final String sign;
    private final Expression expression;

    ExpressionType(String sign, Expression expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public int calculate(int num1, int num2) {
        return expression.calculate(num1, num2);
    }

    public static Map<String, Expression> expressionMap() {
        return Arrays.stream(values()).collect(Collectors.toMap(v -> v.sign, v -> v.expression));
    }

    public static boolean isSign(String str) {
        return Arrays.stream(values()).anyMatch(v -> v.sign.equals(str));
    }
}
