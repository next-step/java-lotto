package lotto;

import java.math.BigDecimal;

public class Money {
    private BigDecimal money;

    public Money(int money) {
        this.money = BigDecimal.valueOf(money);
    }

    public int divide(int value) {
        return money.divide(BigDecimal.valueOf(value)).intValue();
    }

    public BigDecimal getValue() {
        return this.money;
    }
}
