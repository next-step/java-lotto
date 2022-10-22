package lotto.domain;

public class LottoShop {

    private static final int PRICE_PER_LOTTO = 1000;

    public Lottos purchase(PurchaseMoney purchaseMoney) {
        int lottoCount = getPossiblePurchaseLottoCount(purchaseMoney);
        return Lottos.create(lottoCount);
    }

    private int getPossiblePurchaseLottoCount(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getValue() / PRICE_PER_LOTTO;
    }
}
