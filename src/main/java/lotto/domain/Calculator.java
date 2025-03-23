package lotto.domain;

public class Calculator {
    public static long run(long a, long b, Operator operator) {
        if (operator.equals(Operator.PLUS)) {
            return add(a, b);
        } else if (operator.equals(Operator.MINUS)) {
            return subtract(a, b);
        } else if (operator.equals(Operator.MULTIPLY)) {
            return multiply(a, b);
        } else if (operator.equals(Operator.DIVIDE)) {
            return divide(a, b);
        }
        throw new IllegalArgumentException();
    }

    private static long add(long a, long b) {
        return Math.addExact(a, b);
    }

    private static long subtract(long a, long b) {
        return Math.subtractExact(a, b);
    }

    private static long multiply(long a, long b) {
        return Math.multiplyExact(a, b);
    }

    private static long divide(long a, long b) {
        if (a % b != 0)
            throw new ArithmeticException();
        return Math.floorDiv(a, b);
    }
}
