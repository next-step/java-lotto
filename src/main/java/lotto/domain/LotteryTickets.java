package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public static LotteryTickets of(LotteryTicket... tickets) {
        return new LotteryTickets(List.of(tickets));
    }

    public List<LotteryTicket> getLotteryTickets() {
        return lotteryTickets;
    }

    public Ranks calculateRanks(WinningTicket winningTicket) {
        List<Rank> ranks = new ArrayList<>();
        for (LotteryTicket ticket : lotteryTickets) {
            ranks.add(winningTicket.findRank(ticket));
        }
        return new Ranks(ranks);
    }

    public int getCount() {
        return lotteryTickets.size();
    }
}
