package lottery.domain;

import java.util.Objects;

public class TicketCount {

    public final int amount;

    public TicketCount(Money money) {
        this(money.divide(LotteryTicket.TICKET_PRICE.amount).amount);
    }

    public TicketCount(int amount) {
        this.amount = amount;
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

    public TicketCount add(int amount) {
        return new TicketCount(this.amount + amount);
    }

    public TicketCount subtract(int minuend) {
        return new TicketCount(this.amount - minuend);
    }

    public TicketCount multiply(int mulplier) {
        return new TicketCount(this.amount * mulplier);
    }
}
