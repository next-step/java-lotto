package calculator;

import calculator.operation.AddOperation;
import calculator.operation.Operation;

import java.util.Objects;

public class Calculator {

    private int initialNumber;
    private Operation operation;

    public Calculator(int initialNumber) {
        this(initialNumber, new AddOperation());
    }

    public Calculator(Operation operation) {
        this(0, operation);
    }

    public Calculator(int initialNumber, Operation operation) {
        this.initialNumber = initialNumber;
        this.operation = operation;
    }

    public int calculate(int number) {
        this.initialNumber = operation.operate(initialNumber, number);
        return this.initialNumber;
    }

    public void changeOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return initialNumber == that.initialNumber && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialNumber, operation);
    }
}
