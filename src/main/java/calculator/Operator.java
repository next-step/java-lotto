package calculator;

public class Operator {

    public static int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return add(operand1, operand2);
        }

        if (operator.equals("-")) {
            return subtract(operand1, operand2);
        }

        if (operator.equals("*")) {
            return multiply(operand1, operand2);
        }

        if (operator.equals("/")) {
            return divide(operand1, operand2);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자");
    }

    private static int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private static int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private static int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private static int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
