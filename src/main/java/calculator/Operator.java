package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private static final Map<String, Operator> BY_OPERATOR = new HashMap<>();
    static {
        for (Operator operator : values()) {
            BY_OPERATOR.put(operator.operatorSymbol, operator);
        }
    }

    private final String operatorSymbol;
    private final IntBinaryOperator intBinaryOperator;

    Operator(String operatorSign, IntBinaryOperator intBinaryOperator) {
        this.operatorSymbol = operatorSign;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static Operator valueOfOperatorSymbol(String operatorSymbol) {
        return BY_OPERATOR.get(operatorSymbol);
    }

    public int operate(int a, int b) {
        return intBinaryOperator.applyAsInt(a, b);
    }
}
