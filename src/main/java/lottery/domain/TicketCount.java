package lottery.domain;

import java.util.Objects;

public class TicketCount {

    public static final TicketCount ZERO = new TicketCount(0);

    public static final TicketCount ONE = new TicketCount(1);

    private final int amount;

    private TicketCount(int amount) {
        this.amount = amount;
    }

    public static TicketCount valueOf(int amount) {
        if (amount == 0) {
            return ZERO;
        } else if (amount == 1) {
            return ONE;
        }
        return new TicketCount(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    public TicketCount add(TicketCount addend) {
        return TicketCount.valueOf(this.amount + addend.amount);
    }

    public TicketCount subtract(TicketCount subtrahend) {
        return TicketCount.valueOf(this.amount - subtrahend.amount);
    }

    public TicketCount times(TicketCount multiplier) {
        return TicketCount.valueOf(this.amount * multiplier.amount);
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
}
