package lotto.domain;

public class Money {
    private int value;

    public Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 0원보다 커야합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
