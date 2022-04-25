package calculator.domain;

import calculator.domain.operation.AddOperation;
import calculator.domain.operation.Operation;

import java.util.Objects;

public class Calculator {

    private Number initialNumber;
    private Operation operation;

    public Calculator(String value) {
        this(new Number(value), new AddOperation());
    }

    public Calculator(Operation operation) {
        this(new Number(), operation);
    }

    public Calculator(Number initialNumber, Operation operation) {
        this.initialNumber = initialNumber;
        this.operation = operation;
    }

    public Number calculate(Number number) {
        initialNumber.calculate(operation, number);
        return initialNumber;
    }

    public void changeOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(initialNumber, that.initialNumber) && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialNumber, operation);
    }
}
