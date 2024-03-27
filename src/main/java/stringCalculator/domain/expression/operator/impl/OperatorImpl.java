package stringCalculator.domain.expression.operator.impl;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import stringCalculator.error.exception.DivideValueErrorException;
import stringCalculator.error.exception.WhiteSpaceMissingException;

public enum OperatorImpl {

    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> {
            if (leftOperand % rightOperand != 0) {
                throw new DivideValueErrorException(leftOperand, rightOperand);
            }
            return leftOperand / rightOperand;
        });
    private final String symbol;

    private final BinaryOperator<Long> operator;

    OperatorImpl(String symbol, BinaryOperator<Long> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static OperatorImpl fromOperator(String other) {
        return Arrays.stream(OperatorImpl.values())
            .filter(operator -> operator.isEqualsOperator(other))
            .findFirst()
            .orElseThrow(() -> new WhiteSpaceMissingException(other));
    }

    public boolean isEqualsOperator(String other) {
        return symbol.equals(other);
    }

    public Long calculate(long leftOperand, long rightOperand) {
        return operator.apply(leftOperand, rightOperand);
    }
}
