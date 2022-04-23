package stringcalculator.enums;

import stringcalculator.domain.Number;
import stringcalculator.exception.DividedByZeroException;
import stringcalculator.exception.InvalidOperatorException;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", Number::add),
    MINUS("-", Number::minus),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String symbol;
    private final BinaryOperator<Number> operation;

    Operator(String symbol, BinaryOperator<Number> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int operation(Number a, Number b) {
        return operation.apply(a, b).getValue();
    }

    public static int operation(String symbol, int precedingOperand, int followingOperand) {
        if (symbol.equals(PLUS.symbol)) {
            precedingOperand += followingOperand;
        } else if (symbol.equals(MINUS.symbol)) {
            precedingOperand -= followingOperand;
        } else if (symbol.equals(MULTIPLY.symbol)) {
            precedingOperand *= followingOperand;
        } else if (symbol.equals(DIVIDE.symbol)) {
            divideValidate(followingOperand);
            precedingOperand /= followingOperand;
        } else {
            throw new InvalidOperatorException();
        }
        return precedingOperand;
    }

    private static void divideValidate(int followingOperand) {
        if (followingOperand == 0) {
            throw new DividedByZeroException();
        }
    }
}
