package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

import static lotto.domain.LottoTickets.PRICE_OF_LOTTO_TICKET;

public class WinningStatistics {

    private final Map<WinningRank, Integer> rankCounts;

    public WinningStatistics() {
        this.rankCounts = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addMatchedTicket(WinningRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public double calculateEarningsRate(int numberOfTickets) {
        long totalPrize = rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getMoneyOfPrize() * entry.getValue())
                .sum();

        return (double) totalPrize / (numberOfTickets * PRICE_OF_LOTTO_TICKET);
    }

    public int getCount(WinningRank rank) {
        return rankCounts.get(rank);
    }
}
