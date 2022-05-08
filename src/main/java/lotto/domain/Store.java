package lotto.domain;

public class Store {

    private final static int LOTTO_PRICE = 1000;

    public static int buyLotto(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPurchaseAmount() / LOTTO_PRICE;
    }
}
