package lotto.domain.result;

import java.util.Map;

public class WinningStatistics {

    private final Double profitRate;

    public WinningStatistics(Map<LottoResult, Integer> numberOfResults, int money) {
        this.profitRate = applyProfitRate(numberOfResults, money);
    }

    private static Double format(double profitRate) {
        return Math.floor(profitRate * 100) / 100.0;
    }

    public Double applyProfitRate(Map<LottoResult, Integer> result, int money) {
        double totalWinning = 0;

        for (LottoResult lottoResult : result.keySet()) {
            final double value = result.get(lottoResult);
            totalWinning += value * lottoResult.getReward();
        }

        return format(totalWinning / money);
    }

    public Double getProfitRate() {
        return profitRate;
    }
}
