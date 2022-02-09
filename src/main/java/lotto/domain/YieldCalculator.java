package lotto.domain;

import java.util.Map;
import lotto.domain.money.Money;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(Map<LottoResult, Integer> lottoResults, Money money) {
        long profit = 0;
        for (Map.Entry<LottoResult, Integer> resultEntry : lottoResults.entrySet()) {
            profit += (long) resultEntry.getValue() * resultEntry.getKey().getWinning();
        }
        return (double) profit / (double) money.getValue();
    }
}
