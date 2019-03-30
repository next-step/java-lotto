package lotto.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryGame {
    public static final int ADD_RANK_COUNT = 1;
    public static final int INITIAL_FOR_EACH = 0;
    public static final int INITIAL_NUMBER = 0;
    List<Lottery> lotteries;
    Map<Rank, Integer> ranks;
    private int tickets;

    public LotteryGame(int tickets) {
        this.tickets = tickets;
        this.lotteries = new ArrayList<>();
        this.ranks = new HashMap<>();
        createTicket(tickets);
    }

    private void createTicket(int tickets) {
        for (int i = INITIAL_FOR_EACH; i < tickets; i++) {
            lotteries.add(new LotteryGenerator().lotteryNumbers());
        }
    }

    public Map<Rank, Integer> getWinningStatistics(WinningNumber winningNumber) {
        for (int i = INITIAL_FOR_EACH; i < lotteries.size(); i++) {
            Rank rank = winningNumber.match(lotteries.get(i));
            ranks.put(rank, getRanks(rank));
        }
        return ranks;
    }

    private int getRanks(Rank rank) {
        if (!ranks.containsKey(rank)) {
            return ADD_RANK_COUNT;
        }
        return ranks.get(rank) + ADD_RANK_COUNT;
    }

    public double getRevenue() {
        int ticketPurchase = tickets * Money.LOTTERY_PRICE;
        int revenue = Rank.sumRevenue(ranks);
        if (ticketPurchase != INITIAL_NUMBER && revenue != INITIAL_NUMBER)
            return new Money(ticketPurchase).yield(new Money(revenue));
        return INITIAL_NUMBER;
    }
}
