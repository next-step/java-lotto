package lotto.domain;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다.");
        }
    }

    public long countLotto() {
        return this.money / LOTTO_PRICE;
    }

    public double profitRate(long profit) {
        return (double) profit / (countLotto() * LOTTO_PRICE);
    }
}
