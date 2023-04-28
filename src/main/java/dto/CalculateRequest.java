package dto;

import domain.Number;
import domain.Operation;

public class CalculateRequest {
    private final Number number1;
    private final Number number2;
    private final Operation operation;

    public CalculateRequest(Number number1, Number number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public Number getNumber1() {
        return number1;
    }

    public Number getNumber2() {
        return number2;
    }

    public Operation getOperation() {
        return operation;
    }
}
