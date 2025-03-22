package calculator;

public class Calculator {
    public static int calculate(OperationUnit unit) {
        int left = unit.getLeft();
        String operand = unit.getOperand();
        int right = unit.getRight();

        int result = 0;

        if ("+".equals(operand)) {
            result = plus(left, right);
        }
        if ("-".equals(operand)) {
            result =  minus(left, right);
        }
        if ("*".equals(operand)) {
            result =  multiply(left, right);
        }
        if ("/".equals(operand)) {
            result =  divide(left, right);
        }

        unit.initialize();

        return result;
    }

    private static int plus(int left, int right) {
        return left + right;
    }

    private static int minus(int left, int right) {
        return left - right;
    }

    private static int multiply(int left, int right) {
        return left * right;
    }

    private static int divide(int left, int right) {
        return left / right;
    }
}
