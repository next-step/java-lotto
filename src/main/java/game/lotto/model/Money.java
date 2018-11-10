package game.lotto.model;

public class Money {
    public static final int LOTTO_PRICE = 1000;

    private final int value;

    public Money(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000보다 작은 금액은 입력 할 수 없습니다.");
        }

        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
