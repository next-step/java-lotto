package lotto.domain;

import java.util.Map;

public class LottoProfit {
    private Double profitRate;

    public LottoProfit(Map<Integer, Integer> ranks, int totalCount) {
        int totalMoney = 0;

        for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
            int match = entry.getKey();
            int count = entry.getValue();
            totalMoney += LottoPrize.getPrize(match) * count;
        }

        profitRate = totalMoney / (double) (totalCount * 1000);
        profitRate = Math.floor(profitRate * 100) / 100.0;
    }

    public Double getProfitRate() {
        return profitRate;
    }
}
