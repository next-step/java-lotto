package lotto;

public class Money {
    private long money;

    public Money(long money) {
        this.money = money;
    }

    public int divide(int value) {
        return (int) money / value;
    }

    public Money subtract(Money money) {
        return new Money(this.money - money.getMoney());
    }

    public long getMoney() {
        return money;
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
        return (int) (money ^ (money >>> 32));
    }
}
