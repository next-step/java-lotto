package lotto;

import java.math.BigDecimal;

public class Money {
    private static final int LOTTERY_MONEY = 1_000;
    private final int money;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        this.money = money;
    }

    public static BigDecimal buyingMoney(int countOfLotto) {
        return new BigDecimal(countOfLotto * LOTTERY_MONEY);
    }

    public int lotteryCount() {
        if (money < LOTTERY_MONEY){
            throw new IllegalArgumentException();
        }
        return money / LOTTERY_MONEY;
    }

    public Money sum(Money money) {
        return new Money(this.money + money.money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }
}
