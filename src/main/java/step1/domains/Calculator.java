package step1.domains;

public class Calculator {
    private static final String DIVIDE_ZERO_MSG = "제수는 0이 될 수 없습니다.";

    public static int plus(int n, int m) {
        return n + m;
    }

    public static int subtraction(int n, int m) {
        return n - m;
    }

    public static int multiply(int n, int m) {
        return n * m;
    }

    public static int divide(int n, int m) {
        if (m == 0) {
            throw new ArithmeticException(DIVIDE_ZERO_MSG);
        }

        return n / m;
    }
}
