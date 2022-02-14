package lotto.domain;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(LottoResult lottoResult, LottoCount lottoCount) {
        double profit = 0;
        for (LottoDescription lottoDescription : LottoDescription.toList()) {
            System.out.println(lottoDescription.getHash() + " " + lottoResult.getCount(
                lottoDescription.getHash()));
            profit +=
                lottoResult.getCount(lottoDescription.getHash()) * lottoDescription.getWinning();
        }
        return profit / lottoCount.getMoney();
    }
}
