package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private static final int DECIMAL_PLACES = 2;

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money create(int amount) {
        return new Money(amount);
    }

    public static Money create(String amount) {
        return new Money(Integer.parseInt(amount));
    }

    public BigDecimal rateReturn(int reward) {
        BigDecimal amountMoney = BigDecimal.valueOf(amount);
        BigDecimal rewardMoney = BigDecimal.valueOf(reward);

        return rewardMoney.divide(amountMoney, DECIMAL_PLACES, RoundingMode.DOWN);
    }

    public int numberOfBuy(int price) {
        return amount / price;
    }
}
