package lottery.domain;

import java.util.List;

public interface BuyBehavior {
    List<LotteryTicket> buyLotteryTickets(int pickCounts, int numberOfTickets);
}
