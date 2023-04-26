package step1.calculator.domain;

public class Operation {

    private final int operand1;
    private final int operand2;
    private final Operator operator;

    private Operation(int operand1, int operand2, Operator operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public static Operation of(int operand1, int operand2, String operator) {
        return new Operation(operand1, operand2, Operator.of(operator));
    }

    public int calculate() {
        return operator.calculate(operand1, operand2);
    }
}
