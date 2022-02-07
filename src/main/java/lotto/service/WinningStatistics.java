package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.factory.UserLottoFactory;

public class WinningStatistics {

    public static HashMap<LottoResult, Integer> getResult(List<LottoResult> results) {
        HashMap<LottoResult, Integer> result = new HashMap<>();
        for (LottoResult lottoResult : results) {
            result.put(lottoResult, result.getOrDefault(lottoResult, 0) + 1);
        }
        return result;
    }

    public static String getProfitRate(HashMap<LottoResult, Integer> result, int purchasePrice) {
        validateQuantityOfResult(result, purchasePrice);
        double totalWinning = 0;

        for (LottoResult lottoResult : result.keySet()) {
            final double value = result.get(lottoResult);
            totalWinning += value * lottoResult.getReward();
        }

        return format(totalWinning / purchasePrice);
    }

    private static void validateQuantityOfResult(HashMap<LottoResult, Integer> result, int purchasePrice) {
        int resultQuantity = result.keySet().stream().mapToInt(result::get).sum();
        if(resultQuantity != UserLottoFactory.getLottoQuantity(purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 반환된 로또 결과 수와 로또 구매 수량이 다릅니다.");
        }
    }

    private static String format(double totalWinning) {
        return String.format("%.2f", totalWinning);
    }

}
