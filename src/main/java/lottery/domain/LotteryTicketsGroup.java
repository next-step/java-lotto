package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTicketsGroup {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTicketsGroup(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<List<Integer>> getLotteryTicketsNumbers() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getLotteryNumbers)
                .collect(Collectors.toList());
    }
}
