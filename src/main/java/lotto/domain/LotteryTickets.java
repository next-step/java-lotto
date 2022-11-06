package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets(List<LotteryTicket> lotteryTickets) {
        this.lotteryTickets = lotteryTickets;
    }

    public static LotteryTickets of(LotteryTicket... tickets) {
        return new LotteryTickets(Arrays.stream(tickets)
                .collect(Collectors.toList()));
    }

    public static LotteryTickets of(List<String> tickets) {
        return new LotteryTickets(tickets.stream()
                .map(LotteryTicket::of)
                .collect(Collectors.toList()));
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

    public void add(LotteryTickets tickets) {
        this.lotteryTickets.addAll(tickets.lotteryTickets);
    }
}
