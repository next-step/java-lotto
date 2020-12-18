package lottery.domain;

import java.util.List;
import java.util.Objects;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTickets that = (LotteryTickets) o;
        return Objects.equals(lotteryTickets, that.lotteryTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryTickets);
    }
}
