package autolotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private List<Lotto> lottoTickets;
    private List<Integer> lastWeekWinNumber;

    public LottoStatistics(List<Lotto> lottoTickets, List<Integer> lastWeekWinNumber) {
        this.lottoTickets = lottoTickets;
        this.lastWeekWinNumber = lastWeekWinNumber;
    }

    public Map<Rank, Integer> calcuratorRankCount() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto ticket : lottoTickets) {
            Rank rank = Rank.of((int) ticket.lottoNumbers().stream()
                    .filter(lastWeekWinNumber::contains)
                    .count());
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    public double calcuratorProfit(Map<Rank, Integer> rankCount, int ticketsCount) {
        double totalPrize = rankCount.entrySet().stream()
                .mapToDouble(entry -> (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
        if (totalPrize == ZERO) {
            return ZERO;
        }
        return (double) totalPrize / (ticketsCount * LOTTO_PRICE);
    }
}
