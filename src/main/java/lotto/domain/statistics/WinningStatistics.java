package lotto.domain.statistics;

import java.util.HashMap;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;
import lotto.domain.result.NumberOfResults;

public class WinningStatistics {

    private final NumberOfResults numberOfResults;
    private final String profitRate;

    public WinningStatistics(LottoResults lottoResults, int purchasePrice) {
        this.numberOfResults = new NumberOfResults(lottoResults.getRawLottoResults());
        this.profitRate = applyProfitRate(numberOfResults.getRawNumberOfResults(), purchasePrice);
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
