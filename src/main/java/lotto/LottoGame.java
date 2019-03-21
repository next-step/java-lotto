package lotto;

public class LottoGame {
    public static PurchaseHistory purchase(final int payment, LottoGenerator lottoGenerator) {
        return new PurchaseHistory(payment, lottoGenerator);
    }

    public static StatisticsResult analyse(final PurchaseHistory purchaseHistory, final Lotto previousWinningLotto) {
        return new StatisticsResult(purchaseHistory, previousWinningLotto);
    }
}
