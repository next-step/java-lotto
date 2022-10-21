package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class OperatorFactory {
    private static final String NOT_FOUR_OPERATOR_MESSAGE = "사칙연산의 기호가 아닙니다.";

    private OperatorFactory() {
    }

    public static BinaryOperator<Integer> valueOf(String operator) {
        return Arrays.stream(Operation.values())
                .filter(x -> x.getOperator().equals(operator))
                .map(Operation::getCalculator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUR_OPERATOR_MESSAGE));
    }
}
