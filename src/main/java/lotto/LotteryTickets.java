package lotto;

import java.util.List;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }
}
