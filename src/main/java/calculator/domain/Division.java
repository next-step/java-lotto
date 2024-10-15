package calculator.domain;

public class Division implements Operation {
    @Override
    public int calculate(int a, int b) {
        validateDivision(a, b);
        return a / b;
    }

    private static void validateDivision(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }

        if (a % b > 0) {
            throw new IllegalArgumentException();
        }
    }
}
