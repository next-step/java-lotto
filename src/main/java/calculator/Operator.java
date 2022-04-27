package calculator;

import java.util.Map;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final Map<String, Operator> BY_OPERATOR = Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.operatorSymbol, Function.identity()));

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
