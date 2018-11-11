package game.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    public static final int LOTTO_PRICE = 1000;
    public static final int SCALE = 2;

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

    public BigDecimal computeEarningRate(long totalPrize) {
        BigDecimal prize = new BigDecimal(totalPrize);
        return prize.divide(new BigDecimal(this.value), SCALE, RoundingMode.HALF_UP);
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
