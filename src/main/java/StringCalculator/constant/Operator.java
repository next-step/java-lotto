package StringCalculator.constant;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUBTRACT("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public Integer calculate(Integer leftOperand, Integer rightOperand) {
        return expression.apply(leftOperand, rightOperand);
    }

    public static Operator toOperator(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

}
