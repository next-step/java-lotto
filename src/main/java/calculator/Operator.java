package calculator;

import calculator.exception.InvalidOperatorException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUB("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIV("/", (leftOperand, rightOperand) -> {
        if (rightOperand == 0) {
            throw new DivideByZeroException();
        }
        return leftOperand / rightOperand;
    });

    public int apply(int leftOperand, int rightOperand) {
        return this.calculateFunc.apply(leftOperand, rightOperand);
    }

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculateFunc;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculateFunc) {
        this.symbol = symbol;
        this.calculateFunc = calculateFunc;
    }

    public static Operator getOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(InvalidOperatorException::new);
    }
}
