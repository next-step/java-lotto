package calculator;

public class Calculator {
    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int division(int first, int second) {
        validate(first, second);
        return first / second;
    }

    private static void validate(int first, int second) {
        if (first % second != 0) {
            throw new IllegalArgumentException();
        }
    }
}
