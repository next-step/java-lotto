package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private String display;
    private BinaryOperator<Integer> expression;

    Operator(String display, BinaryOperator<Integer> expression) {
        this.display = display;
        this.expression = expression;
    }

    public static Operator getOperator(String operatorDisplay) {
        return Arrays.stream(Operator.values())
                .filter(value -> value.display.equals(operatorDisplay))
                .findFirst()
                .orElse(null);
    }

    public int calculate(int preNum, int postNum) {
        return this.expression.apply(preNum, postNum);
    }
}
