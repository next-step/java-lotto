package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    public Ranks calculateRanks(LotteryTicket winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        for(LotteryTicket ticket : lotteryTickets) {
            ranks.add(ticket.findRank(winningNumbers));
        }
        return new Ranks(ranks);
    }
}
