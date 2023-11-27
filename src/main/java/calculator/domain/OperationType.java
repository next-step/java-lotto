package calculator.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public enum OperationType {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private static final Map<String, OperationType> OPERATION_TYPE_MAP = new HashMap<>();

    private final String type;
    private final DoubleBinaryOperator operation;

    static {
        Arrays.asList(values())
              .forEach(operationTypeEnum -> OPERATION_TYPE_MAP.put(operationTypeEnum.type, operationTypeEnum));
    }

    OperationType(String type, DoubleBinaryOperator operation) {
        this.type = type;
        this.operation = operation;
    }

    public static OperationType getOperationType(String operationType) {
        if (!OPERATION_TYPE_MAP.containsKey(operationType))
            throw new IllegalArgumentException("사칙연산 기호를 확인해주세요");
        return OPERATION_TYPE_MAP.get(operationType);
    }

    public double getOperationResult(double left, double right) {
        return operation.applyAsDouble(left, right);
    }
}
