package lottery.domain;

import java.util.Objects;

public class TicketCount {

    public final int count;

    public TicketCount(Money money) {
        this.count = money.divide(LotteryTicket.PRICE).amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketCount count1 = (TicketCount) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
