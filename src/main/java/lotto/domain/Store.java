package lotto.domain;

public class Store {

    private final static int LOTTO_PRICE = 1000;

    public static PurchaseLotto buyLotto(PurchaseAmount purchaseAmount) {
        int purchaseLotto = purchaseAmount.getPurchaseAmount() / LOTTO_PRICE;
        return new PurchaseLotto(purchaseLotto);
    }
}
