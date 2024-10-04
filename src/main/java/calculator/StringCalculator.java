package calculator;

public class StringCalculator {
    public static int add(String operand1, String operand2) {
        Operands operands = new Operands(operand1,operand2);
        return operands.getOperand1() + operands.getOperand2();
    }

    public static int subtract(String operand1, String operand2) {
        Operands operands = new Operands(operand1, operand2);
        return operands.getOperand1() - operands.getOperand2();
    }

    public static int multiply(String operand1, String operand2) {
        Operands operands = new Operands(operand1, operand2);
        return operands.getOperand1() * operands.getOperand2();
    }

    public static int divide(String operand1, String operand2) {
        Operands operands = new Operands(operand1, operand2);
        return operands.getOperand1() / operands.getOperand2();
    }
}
