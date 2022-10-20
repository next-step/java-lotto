package calculator.domain.operation;

import java.util.function.Supplier;

public enum Operation {
    PLUS("+", AddOperation::new),
    MINUS("-", SubtractOperation::new),
    MULTIPLICATION("*", MultiplyOperation::new),
    DIVISION("/", DivideOperation::new);

    private final String operator;
    private final Supplier<ArithmeticOperation> operationInstance;

    Operation(String operator, Supplier<ArithmeticOperation> operationInstance) {
        this.operator = operator;
        this.operationInstance = operationInstance;
    }

    public String getOperator() {
        return operator;
    }

    public ArithmeticOperation getOperationInstance() {
        return this.operationInstance.get();
    }
}
