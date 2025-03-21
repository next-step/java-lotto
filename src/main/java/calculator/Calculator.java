package calculator;

public class Calculator {
    public static int calculate(OperationUnit unit) {
        int left = unit.getLeft();
        char operand = unit.getOperand();
        int right = unit.getRight();

        if ('+' == operand) {
            return plus(left, right);
        }
        if ('-' == operand) {
            return minus(left, right);
        }
        if ('*' == operand) {
            return multiply(left, right);
        }
        if ('/' == operand) {
            return divide(left, right);
        }

        return 0;
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
