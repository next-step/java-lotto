package lotto.domain;

public class Positive {
    private final int number;

    public Positive(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수일 수 없습니다.");
        }
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }
}
