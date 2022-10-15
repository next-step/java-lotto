package lotto.domain;

public class Money {

    private final int NEGATIVE_BOUND = 0;

    private final int value;

    public Money(final int value) {
        validateValue(value);
        this.value = value;
    }

    public int countMaxNumberOfItemToBuy(final int itemPrice) {
        validateValue(itemPrice);

        if (value == 0) {
            return 0;
        }

        return value / itemPrice;
    }

    private void validateValue(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException("0 미만의 숫자는 허용되지 않습니다.");
        }
    }
}
