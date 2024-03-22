package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final int NONE_RANK = 0;

    // [Key] Rank, [Value] Matched Count (Statistics)
    private final Map<Rank, Integer> statisticsMap;

    public LottoStatistics(LottoTickets lottoTickets, LottoTicket winLottoTicket) {
        this.statisticsMap = new HashMap<>();
        createStatistics(lottoTickets, winLottoTicket);
    }

    private void createStatistics(LottoTickets tickets, LottoTicket winLottoTicket) {
        for (LottoTicket lottoTicket : tickets.get()) {
            Rank rank = lottoTicket.getRank(winLottoTicket);
            addStatistic(rank);
        }
    }

    private void addStatistic(Rank rank) {
        this.statisticsMap.put(rank, this.statisticsMap.getOrDefault(rank, 0) + 1);
    }

    public int getRankCount(Rank rank) {
        int rankCount = this.statisticsMap.get(rank);
        if (hasRankCount(rankCount)) {
            return rankCount;
        }
        return NONE_RANK;
    }

    private boolean hasRankCount(int rankCount) {
        return rankCount != 0;
    }

    public double calculateProfitRate(int purchaseAmount) {
        double profit = 0;
        for (Rank rank : statisticsMap.keySet()) {
            profit += getTotalAmount(rank);
        }
        return profit / purchaseAmount;
    }

    private double getTotalAmount(Rank rank) {
        return statisticsMap.get(rank) * rank.getPrize();
    }
}
