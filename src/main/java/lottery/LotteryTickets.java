package lottery;

import java.util.List;

public class LotteryTickets {
    private final List<lottery.LotteryTicket> lotteryTickets;

    public LotteryTickets(List<lottery.LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<lottery.LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }
}
