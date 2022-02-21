package lotto.domain.result;

import java.util.HashMap;
import java.util.List;

public class WinningStatistics {

    private final NumberOfResults numberOfResults;
    private final String profitRate;

    public WinningStatistics(List<LottoResult> lottoResults, int money) {
        this.numberOfResults = new NumberOfResults(lottoResults);
        this.profitRate = applyProfitRate(numberOfResults.getRawNumberOfResults(), money);
    }

    private static String format(double totalWinning) {
        return String.format("%.2f", totalWinning);
    }

    public String applyProfitRate(HashMap<LottoResult, Integer> result, int purchasePrice) {
        double totalWinning = 0;

        for (LottoResult lottoResult : result.keySet()) {
            final double value = result.get(lottoResult);
            totalWinning += value * lottoResult.getReward();
        }

        return format(totalWinning / purchasePrice);
    }

    public NumberOfResults getNumberOfResults() {
        return numberOfResults;
    }

    public String getProfitRate() {
        return profitRate;
    }
}
