package domain;

public class FourArithmeticOperation implements Operation {

    @Override
    public int calculateFourArithmeticOperation(String symbol, int leftOperand, int rightOperand) {
        if ("+".equals(symbol)) {
            return plus(leftOperand, rightOperand);
        }
        if ("-".equals(symbol)) {
            return minus(leftOperand, rightOperand);
        }
        if ("*".equals(symbol)) {
            return multiply(leftOperand, rightOperand);
        }
        return divide(leftOperand, rightOperand);
    }

    private int plus(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
