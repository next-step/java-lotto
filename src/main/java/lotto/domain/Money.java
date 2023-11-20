package lotto.domain;

import java.util.Objects;

public class Money {

    public static final int THOUSAND_UNIT = 1000;
    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public Money plus(Money addMoney){
        return new Money(money+ addMoney.find());
    }

    public long find() {
        return money;
    }

    public int cutByThousand(){
        return (int) money/ THOUSAND_UNIT;
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

    @Override
    public String toString() {
        return String.valueOf(money);
    }

    public float rateOfreturn(long prize) {
        return (float) prize/money;
    }
}
