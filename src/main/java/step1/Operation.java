package step1;

public class Operation {

    private final String operand1;
    private final String operand2;
    private final String operator;

    public Operation(String operand1, String operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}
