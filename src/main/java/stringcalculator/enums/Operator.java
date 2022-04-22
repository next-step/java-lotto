package stringcalculator.enums;

import stringcalculator.exception.DividedByZeroException;
import stringcalculator.exception.InvalidOperatorException;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private static final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "0으로 나눌 수 없습니다.";
    private static final String INVALID_OPERATOR_ERROR_MESSAGE = "연산자는 \"+, -, *, %\" 만 가능합니다.";
    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
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
