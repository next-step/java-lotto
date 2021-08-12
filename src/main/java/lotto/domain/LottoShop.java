package lotto.domain;

import lotto.view.InputView;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static Money money;
    private static Lottos lottos;

    public LottoShop() {
        money = new Money(InputView.inputPurchaseAmount());
        lottos = new Lottos(getPurchaseQuantity());
    }

    public static int getPurchaseQuantity() {
        return money.getPurchaseMoney() / LOTTO_PRICE;
    }

    public static Lottos getLottos() {
        return lottos;
    }

    public static Money getMoney() {
        return money;
    }
}
