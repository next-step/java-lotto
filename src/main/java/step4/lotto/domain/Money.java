package step4.lotto.domain;

import java.util.Objects;

public class Money {
    private final int money;

    public Money() {
        this.money = 0;
    }

    public Money(int money) {
        this.money = money;
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

    public int divide(int lottoPrize) {
        return this.money / lottoPrize;
    }
}
