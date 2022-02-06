package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoResult;

public class WinningStatistics {

    public static HashMap<LottoResult, Integer> getResult(List<LottoResult> results) {
        HashMap<LottoResult, Integer> result = new HashMap<>();
        for (LottoResult lottoResult : results) {
            result.put(lottoResult, result.getOrDefault(lottoResult, 0) + 1);
        }
        return result;
    }

    public static String getProfitRate(HashMap<LottoResult, Integer> result, int purchasePrice) {
        double totalWinning = 0;

        for (LottoResult lottoResult : result.keySet()) {
            final double value = result.get(lottoResult);
            totalWinning += value * lottoResult.getReward();
        }

        return format(totalWinning / purchasePrice);
    }

    private static String format(double totalWinning) {
        return String.format("%.2f", totalWinning);
    }

}
