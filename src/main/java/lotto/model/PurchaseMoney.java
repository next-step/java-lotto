package lotto.model;

import static lotto.model.Lottos.LOTTO_PRICE;

public class PurchaseMoney {
    private final long purchaseMoney;

    public PurchaseMoney(long purchaseMoney) {
        checkMoneyOverThousand(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public long money() {
        return this.purchaseMoney;
    }

    private void checkMoneyOverThousand(long purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다. 현재 " + purchaseMoney + "원을 입력했습니다.");
        }
    }
}
