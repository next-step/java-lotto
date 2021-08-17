package lotto.domain;

import lotto.strategy.LottoStrategy;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    private static Money money;
    private static Lottos lottos;
    private LottoStrategy lottoStrategy;

    public LottoShop(int purchaseAmount, int manualLottoQuantity) {
        money = new Money(purchaseAmount);
        lottoStrategy = new LottoStrategy(manualLottoQuantity, getPurchaseQuantity() - manualLottoQuantity);
        lottos = new Lottos(lottoStrategy.generateManualLotto(), lottoStrategy.generateAutomaticLotto());
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
