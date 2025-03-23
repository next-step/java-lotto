package lotto.domain;

public class Calculator {
    public int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public int divide(int a, int b) {
        if (a % b != 0)
            throw new ArithmeticException();
        return Math.floorDiv(a, b);
    }
}
