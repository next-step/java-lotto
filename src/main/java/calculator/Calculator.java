package calculator;

public class Calculator {

    public static final String ERROR_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다";

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_BY_ZERO);
        }
        return a / b;
    }
}
