package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final int NONE_RANK = 0;

    // [Key] Rank, [Value] Matched Count (Statistics)
    private final Map<Rank, Integer> statisticsMap;

    public LottoStatistics(LottoTickets lottoTickets, WinLotto winLotto) {
        this.statisticsMap = new HashMap<>();
        createStatistics(lottoTickets, winLotto);
    }

    private void createStatistics(LottoTickets tickets, WinLotto winLotto) {
        for (LottoTicket lottoTicket : tickets.get()) {
            Rank rank = lottoTicket.getRank(winLotto);
            addStatistic(rank);
        }
    }

    private void addStatistic(Rank rank) {
        this.statisticsMap.put(rank, this.statisticsMap.getOrDefault(rank, 0) + 1);
    }

    public Integer getRankCount(Rank rank) {
        Integer rankCount = this.statisticsMap.get(rank);
        if (hasRankCount(rankCount)) {
            return rankCount;
        }
        return NONE_RANK;
    }

    private boolean hasRankCount(Integer rankCount) {
        return rankCount != null;
    }

    public double calculateProfitRate() {
        double profit = 0;
        for (Rank rank : statisticsMap.keySet()) {
            profit += getTotalAmount(rank);
        }
        return profit / (getCountOfLottoTickets() * LottoTicketMachine.AMOUNT_PER_TICKET);
    }

    private double getTotalAmount(Rank rank) {
        return getRankCount(rank) * rank.getPrize();
    }

    private int getCountOfLottoTickets() {
        return statisticsMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}
