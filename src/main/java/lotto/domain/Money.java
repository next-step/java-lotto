package lotto.domain;

import java.util.Objects;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        validateMinusMoney(money);
        validateThousandMoney(money);
    }

    private void validateMinusMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException(String.format("돈이 음수일 수 없습니다. 현재 %d원을 입력했습니다.", money));
        }
    }

    private void validateThousandMoney(long money) {
        if (money % LOTTO_PRICE != 0L) {
            throw new IllegalArgumentException(String.format("천 단위의 돈을 입력해야 합니다. 현재 %d원을 입력했습니다.", money));
        }
    }

    public long countLotto() {
        return this.money / LOTTO_PRICE;
    }

    public ProfitRate findProfitRate(Money profit) {
        return new ProfitRate((double) profit.money / this.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
