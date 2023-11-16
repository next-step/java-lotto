package calculator.domain;

public class Division implements Operator {
    public int operate(int first, int second) {
        validate(first, second);
        return first / second;
    }

    private static void validate(int first, int second) {
        if (first % second != 0) {
            throw new IllegalArgumentException();
        }
    }
}
