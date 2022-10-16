package step1;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLE("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        isDenominatorZero(secondOperand);
        return firstOperand / secondOperand;
    });

    private static final int ZERO = 0;
    private final String symbol;
    private final IntBinaryOperator operator;

    Operator(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
            .filter(operator -> operator.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("피연산자 기호가 아닙니다."));
    }

    private static void isDenominatorZero(int operand) {
        if (operand == ZERO) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    public int operate(int firstOperand, int secondOperand) {
        return this.operator.applyAsInt(firstOperand, secondOperand);
    }
}
