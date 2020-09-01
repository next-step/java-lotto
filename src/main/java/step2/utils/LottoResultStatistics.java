package step2.utils;

import step2.domain.RankPrice;

import java.util.Map;

public class LottoResultStatistics {
    private Map<RankPrice, Long> winnerInventory;

    public LottoResultStatistics(Map<RankPrice, Long> winnerInventory) {
        this.winnerInventory = winnerInventory;
    }

    public Map<RankPrice, Long> getWinningPriceDetails() {
        return this.winnerInventory;
    }

    public double getFinalProfit(float buyMoney) {
        int winnedMoney = this.winnerInventory
                .keySet()
                .stream()
                .mapToInt(RankPrice::getMatchNumber)
                .sum();

        return Math.round(winnedMoney / buyMoney * 100.0) / 100.0;
    }
}
