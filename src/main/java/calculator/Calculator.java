package calculator;

public class Calculator {
    public int plus(int result, int value) {
        return  result + value;
    }

    public int minus(int result, int value) {
        return result - value;
    }

    public int multiply(int result, int value) {
        return result * value;
    }

    public int divide(int result, int value) {
        if (result % value != 0) {
            throw new IllegalArgumentException();
        }
        return result/value;
    }
}
