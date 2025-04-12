package step1.domain;

public class Calculator {

    public Number calculate(Number left, Number right, String operator) {
        Operation operation = OperationFactory.getOperation(operator);
        return operation.operate(left, right);
    }
}
