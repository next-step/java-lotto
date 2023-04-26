package calculator;

import java.util.function.BinaryOperator;

public enum Operator {
    ADD(Integer::sum),
    SUBTRACT((a, b) -> (a - b)),
    MULTIPLY((a, b) -> (a * b)),
    DIVIDE((a, b) -> (a / b));

    private final BinaryOperator<Integer> formula;

    Operator(BinaryOperator<Integer> formula) {
        this.formula = formula;
    }

    public int calculate(int a, int b) {
        return formula.apply(a, b);
    }

}
