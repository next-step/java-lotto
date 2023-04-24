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

    public String calculator(String leftNumber, String rightNumber) {
        Number left = Number.from(leftNumber);
        Number right = Number.from(rightNumber);

        OperationEnum from = OperationEnum.from(operation);
        return String.valueOf(from.calculator(left.getNumber(), right.getNumber()));
    }

    public enum OperationEnum {
        ADD("+", (number1, number2) -> number1 + number2),
        MINUS("-", (number1, number2) -> number1 - number2),
        MULTIPLY("*", (number1, number2) -> number1 * number2),
        DIVIDE("/", (number1, number2) -> number1 / number2);

        private final String operation;
        private final IntBinaryOperator expression;

        OperationEnum(String symbol, IntBinaryOperator expression) {
            this.operation = symbol;
            this.expression = expression;
        }

        public int calculator(int number1, int number2) {
            return getExpression().applyAsInt(number1, number2);
        }

        public static OperationEnum from(String operation) {
            return Arrays.stream(values())
                    .filter(value -> operation.equals(value.operation))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 값 입력"));
        }

        public IntBinaryOperator getExpression() {
            return expression;
        }
    }
}
