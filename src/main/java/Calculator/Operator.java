package Calculator;

public class Operator {
    private String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }

    public int calculateProcess(int operand1, int operand2) {
        int result = 0;

        switch (this.operator) {
            case "+":
                result = add(operand1, operand2);
                break;
            case "-":
                result = minus(operand1, operand2);
                break;
            case "*":
                result = multiply(operand1, operand2);
                break;
            case "/":
                result = divide(operand1, operand2);
                break;
            default:
                throw new IllegalArgumentException(operator + "는 사칙연산 기호가 아닙니다: ");
        }

        return result;
    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
