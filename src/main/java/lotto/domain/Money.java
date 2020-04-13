package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private static final int PRICE_OF_LOTTO = 1000;
    private final int countOfLotto;
    private final BigDecimal money;

    public Money(int money) {
        validateMoney(money);
        this.countOfLotto = money / PRICE_OF_LOTTO;
        this.money = new BigDecimal(String.valueOf(money));
    }

    private void validateMoney(int money) {
        if (money < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("로또 1장의 가격은 1000원 입니다.");
        }
    }

    public int getCountOfLotto() {
        return countOfLotto;
    }

    public BigDecimal getEarningRate(int totalWinningMoney) {
        return new BigDecimal(String.valueOf(totalWinningMoney)).divide(money, 2, BigDecimal.ROUND_FLOOR);
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
