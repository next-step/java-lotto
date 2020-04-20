package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private static final int PRICE_OF_LOTTO = 1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("로또 1장의 가격은 1000원 입니다.");
        }
    }

    public Money buyManual(int countOfManual) {
        return new Money(money - (PRICE_OF_LOTTO * countOfManual));
    }

    public int getCountOfLotto() {
        return this.money / PRICE_OF_LOTTO;
    }

    public BigDecimal getEarningRate(int totalWinningMoney) {
        BigDecimal money = new BigDecimal(String.valueOf(this.money));
        return new BigDecimal(String.valueOf(totalWinningMoney)).divide(money, 2, RoundingMode.FLOOR);
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
