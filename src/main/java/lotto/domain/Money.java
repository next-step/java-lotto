package lotto.domain;

import java.util.Objects;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }
    public Money plus(long addMoney){
        return new Money(this.money+addMoney);
    }

    public long find(){
        return this.money;
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
