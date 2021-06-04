package lottery.domain;

import java.util.Objects;

public class Money {

    public static final int MINIMUM_PRICE = 0;
    private static final Integer DEFAULT_LOTTERY_PRICE = 1_000;

    private final Integer money;

    public Money(int money) {
        validatePrice(money);

        this.money = money;
    }

    public int calculatePerLottery() {
        return money / DEFAULT_LOTTERY_PRICE;
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException("금액은 0원이상 이어야 합니다.");
        }
    }

    public double toDouble() {
        return (double) money;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
