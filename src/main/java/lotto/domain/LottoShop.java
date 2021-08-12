package lotto.domain;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;
    private static Money money;
    private static Lottos lottos;

    public LottoShop(int purchaseAmount) {
        money = new Money(purchaseAmount);
        lottos = new Lottos(getPurchaseQuantity());
    }

    public static int getPurchaseQuantity() {
        return money.getPurchaseMoney() / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public static Money getMoney() {
        return money;
    }
}
