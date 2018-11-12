package lotto.domain;

import java.math.BigDecimal;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isLess(int value) {
        return this.value < value;
    }

    public int getGameTImes(int lottoGameFee) {
        return value / lottoGameFee;
    }

    public double calcurateProfitRate(int totalPrize) {
        return (double) totalPrize / this.value;
    }

    public static Money of(int value) {
        return new Money(value);
    }
}
