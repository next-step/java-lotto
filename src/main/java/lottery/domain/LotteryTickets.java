package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTickets {
    private List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        this.lotteryTickets = new ArrayList<>();
    }

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    public void concat(LotteryTickets lotteryTickets) {
        this.lotteryTickets = Stream.concat(this.lotteryTickets.stream(), lotteryTickets.getLotteryTickets().stream())
                .collect(Collectors.toList());
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
