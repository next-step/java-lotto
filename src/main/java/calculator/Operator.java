package calculator;

import java.util.Map;
import java.util.Optional;
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

    Operator(String operatorSymbol, IntBinaryOperator intBinaryOperator) {
        this.operatorSymbol = operatorSymbol;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static Operator valueOfOperatorSymbol(String operatorSymbol) {
        return Optional.ofNullable(BY_OPERATOR.get(operatorSymbol)).orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙 연산자가 아닙니다.", operatorSymbol)));
    }

    public int operate(int operand1, int operand2) {
        return intBinaryOperator.applyAsInt(operand1, operand2);
    }

    public static boolean isOperator(String element) {
        return BY_OPERATOR.containsKey(element);
    }
}
