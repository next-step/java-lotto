package lotto.domain;

import calculator.InvalidInputException;

public class LottoShop {
    private static final String INVALID_MANUAL_QUANTITY = "수동 구매 로또 수가 전체 구입금액을 초과합니다.";
    private static final int LOTTO_PRICE = 1000;

    private static Money money;
    private static Lottos lottos;

    public LottoShop(int purchaseAmount, int manualLottoQuantity) {
        money = new Money(purchaseAmount);
        lottos = new Lottos(getPurchaseQuantity(), validateManualQuantity(manualLottoQuantity));
    }

    private int validateManualQuantity(int manualQuantity) {
        if (manualQuantity > getPurchaseQuantity()) {
            throw new InvalidInputException(INVALID_MANUAL_QUANTITY);
        }
        return manualQuantity;
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
