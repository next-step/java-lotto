package calculator.domain;

import calculator.domain.operation.ArithmeticOperation;
import calculator.domain.operation.Operation;

import java.util.Arrays;

public class OperatorFactory {
    private static final String NOT_FOUR_OPERATOR_MESSAGE = "사칙연산의 기호가 아닙니다.";

    private OperatorFactory() {
    }

    public static ArithmeticOperation valueOf(String operator) {
        return Arrays.stream(Operation.values())
                .filter(x -> x.getOperator().equals(operator))
                .map(Operation::getOperationInstance)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUR_OPERATOR_MESSAGE));
    }
}
