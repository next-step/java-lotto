package calculator;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static int calculateOperationUnit(OperationUnit operationUnit) {
        int left = operationUnit.getLeft();
        String operator = operationUnit.getOperator();
        int right = operationUnit.getRight();

        int result = calculate(left, operator, right);
        operationUnit.clear();

        return result;
    }

    public static int calculate(int left, String operator, int right) {
        int result = 0;

        if (PLUS.equals(operator)) {
            result = plus(left, right);
        }
        if (MINUS.equals(operator)) {
            result = minus(left, right);
        }
        if (MULTIPLY.equals(operator)) {
            result = multiply(left, right);
        }
        if (DIVIDE.equals(operator)) {
            result = divide(left, right);
        }

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
