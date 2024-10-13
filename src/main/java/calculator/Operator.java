package calculator;

import calculator.exception.DivisionCannotBeZeroException;
import calculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DEVIDE("/", (a, b) -> {
        validDivision(b);
        return a / b;
    });

    private final String operator;
    private final IntBinaryOperator operatorMethod;

    Operator(String operator, IntBinaryOperator operatorMethod) {
        this.operator = operator;
        this.operatorMethod = operatorMethod;
    }

    private static void validDivision(int division) {
        if (division == 0) {
            throw new DivisionCannotBeZeroException(division);
        }
    }

    public static IntBinaryOperator getOperatorMethod(String operatorRequest) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operatorRequest))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException(operatorRequest))
                .operatorMethod;
    }

}
