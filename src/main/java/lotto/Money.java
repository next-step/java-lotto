package lotto;

import java.util.Objects;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private int money;
    private int manualCount;

    public Money(int money) {
        this.money = money;
        this.manualCount = 0;
    }

    public Money(int money, int manualCount) {
        if (manualCount > (money / LOTTO_PRICE)){
            throw new IllegalArgumentException();
        }
        this.money = money;
        this.manualCount = manualCount;
    }

    public int countOfBuyingLotto(){
        return (this.money / LOTTO_PRICE) - manualCount;
    }

    public Money sum(Money prize) {
        return new Money(this.money + prize.money);
    }

    public double rateOfReturn(Money prize) {
        return (prize.money * 100) / money;
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
}
