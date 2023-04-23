package step1.domain.model;

import step1.exception.OperationIllegalStateException;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Operation {
    private static final String[] OPERATIONS = {"+", "-", "*", "/"};

    private String operation;

    public Operation(String operation) {
        if (!isOperation(operation)) {
            throw new OperationIllegalStateException("유효한 연산자가 아닙니다.");
        }
        this.operation = operation;
    }

    public static Operation from(final String operation) {
        return new Operation(operation);
    }

    private boolean isOperation(String operation) {
        return Arrays.stream(OPERATIONS)
                .anyMatch(operation::equals);
    }

    public enum OperationEnum {
        ADD("+", (number1, number2) -> number1 + number2),
        MINUS("-", (number1, number2) -> number1 - number2),
        MULTIPLY("*", (number1, number2) -> number1 * number2),
        DIVIDE("/", (number1, number2) -> number1 / number2);

        private final String symbol;
        private final IntBinaryOperator expression;

        OperationEnum(String symbol, IntBinaryOperator expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public int calculator(int number1, int number2) {
            return getExpression().applyAsInt(number1, number2);
        }

        public IntBinaryOperator getExpression() {
            return expression;
        }
    }

    public String calculator(String leftNumber, String rightNumber) {
        Number left = Number.from(leftNumber);
        Number right = Number.from(rightNumber);

        OperationEnum operationEnum = null;
        if ("+".equals(operation)) {
            operationEnum = OperationEnum.ADD;
        } else if ("-".equals(operation)) {
            operationEnum = OperationEnum.MINUS;
        } else if ("*".equals(operation)) {
            operationEnum = OperationEnum.MULTIPLY;
        } else if ("/".equals(operation)) {
            operationEnum = OperationEnum.DIVIDE;
        }
        return String.valueOf(operationEnum.calculator(left.getNumber(), right.getNumber()));

    }
}
