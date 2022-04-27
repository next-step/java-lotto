package calculator.domain;

import calculator.domain.operation.AddOperation;
import calculator.domain.operation.Operation;

import java.util.Objects;

public class Operator {

    private static final int INITIAL_NUMBER = 0;

    private int initialNumber;
    private Operation operation;

    public Operator(String value) {
        this(Integer.parseInt(value), new AddOperation());
    }

    public Operator(Operation operation) {
        this(INITIAL_NUMBER, operation);
    }

    public Operator(int initialNumber, Operation operation) {
        this.initialNumber = initialNumber;
        this.operation = operation;
    }

    public void calculate(int number) {
        initialNumber = operation.operate(initialNumber, number);
    }

    public int result() {
        return initialNumber;
    }

    public void changeOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return initialNumber == operator.initialNumber && Objects.equals(operation, operator.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialNumber, operation);
    }
}
