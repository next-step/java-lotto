package calculator.domain;

public class Calculator {

    public static int add(int addend1, int addend2) {
        return addend1 + addend2;
    }

    public static int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public static int multiply(int multiplicand, int multiplier) {
        return multiplicand * multiplier;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return dividend / divisor;
    }
}
