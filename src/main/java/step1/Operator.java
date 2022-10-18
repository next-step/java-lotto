package step1;

import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b);

    private final String arithmetic;
    private final BinaryOperator<Integer> formula;

    Operator(String arithmetic, BinaryOperator<Integer> formula) {
        this.arithmetic = arithmetic;
        this.formula = formula;
    }

    public int executedResult(int operand, int anotherOperand) {
        return formula.apply(operand, anotherOperand);
    }

}
