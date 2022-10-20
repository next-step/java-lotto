package step1.arithmeticExpression.operators.operator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b)
    ;

    private final String arithmetic;
    private final BinaryOperator<Integer> formula;

    Operator(String arithmetic, BinaryOperator<Integer> formula) {
        this.arithmetic = arithmetic;
        this.formula = formula;
    }

    public static Operator foundOperator(String arithmetic) {
        return Arrays.stream(Operator.values())
                .filter(operator -> Objects.equals(operator.arithmetic, arithmetic))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("올바른 연산자가 아닙니다."));
    }

    public int executedResult(int operand, int anotherOperand) {
        return formula.apply(operand, anotherOperand);
    }

}
