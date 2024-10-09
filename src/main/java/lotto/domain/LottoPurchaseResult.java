package lotto.domain;

public class LottoPurchaseResult {
    private final Money purchasedMoney;
    private final LottoBundle lottoBundle;

    public LottoPurchaseResult(final Money purchasedMoney, final LottoBundle lottoBundle) {
        this.purchasedMoney = purchasedMoney;
        this.lottoBundle = lottoBundle;
    }

    public Money getPurchasedMoney() {
        return purchasedMoney;
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }

    public int size() {
        return lottoBundle.size();
    }
}
