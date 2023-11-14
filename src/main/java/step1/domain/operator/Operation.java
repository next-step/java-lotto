package step1.domain.operator;

import java.util.Arrays;

public enum Operation {

    ADDITION("+", new AdditionOperator()),
    SUBTRACTION("-", new SubtractionOperator()),
    MULTIPLICATION("*", new MultiplicationOperator()),
    DIVISION("/", new DivisionOperator());

    private final String operationSymbol;
    private final Operator operator;

    Operation(String operationSymbol, Operator operator) {
        this.operationSymbol = operationSymbol;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    public static Operation from(String operationSymbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.operationSymbol.equals(operationSymbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}
