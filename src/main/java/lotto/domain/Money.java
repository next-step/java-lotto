package lotto.domain;

public class Money {

    private final int money;

    public Money(final int money) {
        this.money = money;
    }

    public int countOfTickets(final int priceOfTicket) {
        return money / priceOfTicket;
    }

    public float rateOfReturn(final float sumResult) {
        return sumResult / this.money;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return money;
    }
}
