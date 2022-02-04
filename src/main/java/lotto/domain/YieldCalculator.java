package lotto.domain;

import java.util.List;

public class YieldCalculator {

    private YieldCalculator() {}

    public static double calcuateYield(List<LottoResult> lottoResults, int money) {
        long profit = 0;
        for(LottoResult lottoResult: lottoResults) {
            profit += lottoResult.getCount() * lottoResult.getWinning();
        }
        return profit / money;
    }
}
