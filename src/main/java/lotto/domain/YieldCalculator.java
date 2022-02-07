package lotto.domain;

import java.util.Map;
import lotto.domain.money.Money;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(Map<LottoResult, Integer> lottoResults, Money money) {
        long profit = 0;
        for (LottoResult lottoResult : lottoResults.keySet()) {
            profit = profit + (long) lottoResults.get(lottoResult) * lottoResult.getWinning();
        }
        return (double) (profit / money.getValue());
    }
}
