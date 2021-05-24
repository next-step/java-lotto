package lottoauto;

import java.util.Objects;

public final class Money {
    private static final String MONEY_UNIT = "원";
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int calcLottoCount(final int lottoTicketPrice) {
        return money / lottoTicketPrice;
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
        return "(" + money + MONEY_UNIT + ")";
    }

    public int calcProceed(int count) {
        return this.money * count;
    }

    public double calcProceedsRate(Money proceeds) {
        return proceeds.divide(this.money);
    }

    private double divide(int investment) {
        return this.money / (double) investment;
    }
}
