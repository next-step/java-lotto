package lotto.domain;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다.");
        }
    }

    public long countLotto() {
        return this.money / LOTTO_PRICE;
    }

    public double profitRate(long profit) {
        return (double) profit / (this.countLotto() * LOTTO_PRICE);
    }
}
