package lotto.domain;

import java.util.List;

public class YieldCalculator {

    private YieldCalculator() {}

    public static double calculateYield(List<LottoResult> lottoResults, int money) {
        long profit = 0;
        for(LottoResult lottoResult: lottoResults) {
            profit = profit + (long) lottoResult.getCount() * lottoResult.getWinning();
        }
        return (double) (profit / money);
    }
}
