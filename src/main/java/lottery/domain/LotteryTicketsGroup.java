package lottery.domain;

import java.util.List;

public class LotteryTicketsGroup {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTicketsGroup(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public boolean isSameCounts(int lotteryTicketCounts) {
        return lotteryTickets.size() == lotteryTicketCounts;
    }
}
