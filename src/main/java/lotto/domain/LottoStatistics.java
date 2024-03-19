package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    // [Key] LottoInformation, [Value] Matched Count (Statistics)
    private final Map<LottoInformation,  Integer> statisticsMap;

    public LottoStatistics(LottoTickets lottoTickets, LottoTicket winLottoTicket) {
        this.statisticsMap = new HashMap<>();
        createStatistics(lottoTickets, winLottoTicket);
    }

    private void createStatistics(LottoTickets tickets, LottoTicket winLottoTicket) {
        for (LottoTicket lottoTicket : tickets.get()) {
            LottoInformation lottoInformation = lottoTicket.getInformation(winLottoTicket);
            addStatistic(lottoInformation);
        }
    }

    private void addStatistic(LottoInformation information) {
        this.statisticsMap.put(information, this.statisticsMap.getOrDefault(information, 0) + 1);
    }

    public int getMatchedLottoCount(LottoInformation information) {
        return this.statisticsMap.get(information);
    }


    public double calculateProfitRate(int purchaseAmount) {
        double totalProfit = 0;
        for (LottoInformation information : statisticsMap.keySet()) {
            totalProfit += getTotalAmount(information);
        }
        return totalProfit / purchaseAmount;
    }

    private double getTotalAmount(LottoInformation information) {
        return statisticsMap.get(information) * LottoInformation.getWinAmount(information);
    }
}
