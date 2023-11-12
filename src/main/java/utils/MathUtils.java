package utils;

public class MathUtils {

    private MathUtils() { //인스턴스화 방지
    }

    public static int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public static int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public static int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return dividend / divisor;
    }

    public static boolean isOddValue(int input) {
        return input % 2 == 1;
    }

    public static boolean isEvenValue(int input) {
        return input % 2 == 0;
    }
}
