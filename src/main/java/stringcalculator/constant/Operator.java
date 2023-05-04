package stringcalculator.constant;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUBTRACT("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String symbol;
    private final BinaryOperator<Integer> expression;

    Operator(String symbol, BinaryOperator<Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public Integer calculate(Integer leftOperand, Integer rightOperand) {
        return expression.apply(leftOperand, rightOperand);
    }

    public static Operator toOperator(String symbol) {
        return Arrays.stream(values())
            .filter((operator -> operator.symbol.equals(symbol)))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

}
