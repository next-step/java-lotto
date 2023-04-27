package lotto.domain;

public class Price {
    /**
     * 가격을 입력받는 값 객체
     */
    private final int value;

    public Price(int value) {
        validatePrice(value);
        this.value = value;
    }

    private void validatePrice(int value) {
        if (value < Store.LOTTERY_PRICE) {
            throw new IllegalArgumentException("로또 가격 보다 같거나 큰 값을 입력해 주세요.");
        }
    }

    public boolean isNotDivisible() {
        return value % Store.LOTTERY_PRICE != 0;
    }

    public int dividedBy(int lotteryPrice) {
        return value / lotteryPrice;
    }
}
