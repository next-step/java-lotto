package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    // [Key] LottoPrize, [Value] Matched Count (Statistics)
    private final Map<LottoPrize,  Integer> statisticsMap;

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
        if (prize != null) {
            this.statisticsMap.put(prize, this.statisticsMap.getOrDefault(prize, 0) + 1);
        }
    }

    public int getMatchedLottoCount(LottoPrize prize) {
        if (this.statisticsMap.containsKey(prize)) {
            return this.statisticsMap.get(prize);
        }
        return 0;
    }


    public double calculateProfitRate(int purchaseAmount) {
        double totalProfit = 0;
        for (LottoPrize prize : statisticsMap.keySet()) {
            totalProfit += getTotalAmount(prize);
        }
        return totalProfit / purchaseAmount;
    }

    private double getTotalAmount(LottoPrize prize) {
        return statisticsMap.get(prize) * LottoPrize.getWinAmount(prize);
    }
}
