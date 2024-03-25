package lotto;

import java.math.BigDecimal;

public class Money {
    private long money;

    public Money(long money) {
        this.money = money;
    }

    public int divide(int value) {
        return (int) money / value;
    }

    public long getMoney() {
        return money;
    }
}
