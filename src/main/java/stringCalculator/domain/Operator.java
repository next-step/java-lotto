package stringCalculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String value;
    private final BinaryOperator<Integer> operation;

    Operator(String value, BinaryOperator<Integer> operation) {
        this.value = value;
        this.operation = operation;
    }

    public static Operator find(String stringOperator) {
        return Arrays.stream(values()).filter(operator -> operator.value.equals(stringOperator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Need correct arithmetic operator"));
    }

    public int calculate(int originalNumber, int toCalculateNumber) {
        validation(toCalculateNumber);
        return this.operation.apply(originalNumber, toCalculateNumber);
    }

    private void validation(int toCalculateNumber) {
        if (this == DIVIDE) {
            validationForDivide(toCalculateNumber);
        }
    }

    private void validationForDivide(int input) {
        if (isZero(input)) {
            throw new ArithmeticException("You cannot divide a number with 0");
        }
    }

    private boolean isZero(int input) {
        return input == 0;
    }

}




