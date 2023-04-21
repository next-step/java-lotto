package step1;

public class Calculator {

    public static String calculate(Operation operation) {
        String operator = operation.getOperator();
        if (Operator.PLUS.isEqual(operator)) {
            return plus(operation.getOperand1(), operation.getOperand2());
        }
        if (Operator.MINUS.isEqual(operator)) {
            return minus(operation.getOperand1(), operation.getOperand2());
        }
        if (Operator.MULTIPLY.isEqual(operator)) {
            return multiply(operation.getOperand1(), operation.getOperand2());
        }
        if (Operator.DIVIDE.isEqual(operator)) {
            return divide(operation.getOperand1(), operation.getOperand2());
        }
        return "";
    }

    private static String plus(String operand1, String operand2) {
        return String.valueOf(Integer.parseInt(operand1) + Integer.parseInt(operand2));
    }

    private static String minus(String operand1, String operand2) {
        return String.valueOf(Integer.parseInt(operand1) - Integer.parseInt(operand2));
    }

    private static String multiply(String operand1, String operand2) {
        return String.valueOf(Integer.parseInt(operand1) * Integer.parseInt(operand2));
    }

    private static String divide(String operand1, String operand2) {
        return String.valueOf(Integer.parseInt(operand1) / Integer.parseInt(operand2));
    }
}
