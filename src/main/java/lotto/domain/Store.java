package lotto.domain;

public class Store {

    private final static int LOTTO_PRICE = 1000;

    public static PurchaseAmount buyLotto(Money money) {
        int purchaseAmount = money.getMoney() / LOTTO_PRICE;
        return new PurchaseAmount(purchaseAmount);
    }
}
