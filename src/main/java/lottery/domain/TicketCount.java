package lottery.domain;

import java.util.Objects;

public class TicketCount {

    public static final TicketCount ZERO = new TicketCount(0);

    public final int amount;

    private TicketCount(int amount) {
        this.amount = amount;
    }

    public static TicketCount of(Money money) {
        return valueOf(money.divide(LotteryTicket.TICKET_PRICE.amount).amount);
    }

    public static TicketCount valueOf(int amount) {
        return amount == 0 ? ZERO : new TicketCount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketCount count1 = (TicketCount) o;
        return amount == count1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money getPrice() {
        return LotteryTicket.TICKET_PRICE.times(this.amount);
    }

    public TicketCount add(int addend) {
        return TicketCount.valueOf(this.amount + addend);
    }

    public TicketCount subtract(int subtrahend) {
        return TicketCount.valueOf(this.amount - subtrahend);
    }

    public TicketCount times(int multiplier) {
        return TicketCount.valueOf(this.amount * multiplier);
    }
}
