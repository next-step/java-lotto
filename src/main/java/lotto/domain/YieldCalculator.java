package lotto.domain;

import lotto.domain.money.Money;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(MatchResult lottoResults, Money money) {
        long profit = 0;
        for (LottoResult lottoResult : lottoResults.getLottoResultSet()) {
            profit += (long) lottoResults.getCount(lottoResult) * lottoResult.getWinning();
        }
        return (double) profit / (double) money.getValue();
    }
}
