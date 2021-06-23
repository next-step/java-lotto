package lotto.core.omr;

public class Price {
    private final int value;

    public Price(final int money) {
        this.value = money;
    }

    public int howMany(int money) {
        if (money < this.value) {
            return 0;
        }

        return money / value;
    }

    public int calcAmountWithPrice(final int amount) {
        return amount * value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
