package lotto.domain;

public class Number implements Comparable<Number> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public Number(int input) {
        validateNumber(input);
        this.number = input;
    }

    private void validateNumber(int input) {
        if (input < MIN_NUMBER || input > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d부터 %d사이의 숫자여야합니다 : %d", MIN_NUMBER, MAX_NUMBER, input));
        }
    }

    @Override
    public int compareTo(Number target) {
        return this.number - target.number;
    }

    @Override
    public String toString() {
        return this.number + "";
    }
}
