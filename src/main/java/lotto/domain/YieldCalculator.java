package lotto.domain;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(LottoResult lottoResult, int money) {
        long profit = 0;
        for (LottoDescription lottoDescription : LottoDescription.toList()) {
            profit +=
                lottoResult.getCount(lottoDescription.getHash()) * lottoDescription.getWinning();
        }
        return profit / money;
    }
}
