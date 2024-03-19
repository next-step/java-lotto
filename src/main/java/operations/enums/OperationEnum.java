package operations.enums;

import operations.Number;

import java.util.Arrays;

public enum OperationEnum {
    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a - b),
    DIVISION("/", (a, b) -> a / b),
    MULTIPLICATION("*", (a, b) -> a * b);

    private final String operation;

    private final CalculateStrategy calculateStrategy;

    OperationEnum(String operation, CalculateStrategy calculateStrategy) {
        this.operation = operation;
        this.calculateStrategy = calculateStrategy;
    }

    public static int calculate(String operation, Number number, Number otherNumber) {
        if (operation == null || operation.isBlank()) {
            throw new IllegalArgumentException("연산자가 널값이거나 비어있습니다.");
        }

        String operationUpperCase = operation.toUpperCase();
        OperationEnum operationEnum = Arrays.stream(values())
                .filter(operationEnumTest -> operationEnumTest.operation.equals(operationUpperCase))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효한 연산자를 찾을 수 없습니다."));

        return operationEnum.calculateStrategy.calculate(number.number(), otherNumber.number());
    }

    public int calculate(int a, int b) {
        return this.calculateStrategy.calculate(a, b);
    }


    public interface CalculateStrategy {
        int calculate(int a, int b);
    }

}
