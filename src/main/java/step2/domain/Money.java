package step2.domain;

public class Money {

    public static final Money ZERO_MONEY = new Money(0);

    private final int value;

    public Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 음수 일수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
