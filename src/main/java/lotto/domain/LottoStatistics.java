package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private static final int NONE_MATCH = 0;

    // [Key] LottoPrize, [Value] Matched Count (Statistics)
    private final Map<LottoPrize, Integer> statisticsMap;

    public LottoStatistics(LottoTickets lottoTickets, LottoTicket winLottoTicket) {
        this.statisticsMap = new HashMap<>();
        createStatistics(lottoTickets, winLottoTicket);
    }

    private void createStatistics(LottoTickets tickets, LottoTicket winLottoTicket) {
        for (LottoTicket lottoTicket : tickets.get()) {
            LottoPrize lottoPrize = lottoTicket.getPrize(winLottoTicket);
            addStatistic(lottoPrize);
        }
    }

    private void addStatistic(LottoPrize prize) {
        if (hasPrize(prize)) {
            this.statisticsMap.put(prize, this.statisticsMap.getOrDefault(prize, 0) + 1);
        }
    }

    private boolean hasPrize(LottoPrize prize) {
        return prize != null;
    }

    public int getMatchCount(LottoPrize prize) {
        if (hasPrizeStatistics(prize)) {
            return this.statisticsMap.get(prize);
        }
        return NONE_MATCH;
    }

    private boolean hasPrizeStatistics(LottoPrize prize) {
        return this.statisticsMap.containsKey(prize);
    }

    public double calculateProfitRate(int purchaseAmount) {
        double profit = 0;
        for (LottoPrize prize : statisticsMap.keySet()) {
            profit += getTotalAmount(prize);
        }
        return profit / purchaseAmount;
    }

    private double getTotalAmount(LottoPrize prize) {
        return statisticsMap.get(prize) * prize.getPrize();
    }
}
