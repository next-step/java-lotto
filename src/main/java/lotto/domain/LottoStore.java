package lotto.domain;

public class LottoStore {
    public static final int LOTTO_PURCHASE_AMOUNT = 1000;

    public LottoPurchaseResult purchase(final Money money) {
        return new LottoPurchaseResult(money, LottoBundle.issues(money.getMoney() / LOTTO_PURCHASE_AMOUNT));
    }
}
