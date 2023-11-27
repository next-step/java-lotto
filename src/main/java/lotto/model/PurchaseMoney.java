package lotto.model;

import static lotto.model.Lotto.LOTTO_PRICE;

public class PurchaseMoney {
    private final long purchaseMoney;
    private final ManualCount manualCount;

    public PurchaseMoney(long purchaseMoney, ManualCount manualCount) {
        checkMoneyOverThousand(purchaseMoney);
        checkManualMoneyUnderPurchaseMoney(purchaseMoney, manualCount.count());
        this.purchaseMoney = purchaseMoney;
        this.manualCount = manualCount;
    }

    public PurchaseMoney(long purchaseMoney) {
        this(purchaseMoney, new ManualCount(0));
    }

    private void checkManualMoneyUnderPurchaseMoney(long purchaseMoney, int manualCount) {
        if (purchaseMoney < (long) manualCount * LOTTO_PRICE) {
            throw new IllegalArgumentException("수동 구매 금액이 총 구입금액보다 큽니다.");
        }
    }

    private void checkMoneyOverThousand(long purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다. 현재 " + purchaseMoney + "원을 입력했습니다.");
        }
    }

    public long money() {
        return this.purchaseMoney;
    }

    public int manualCount() {
        return this.manualCount.count();
    }

    public int autoCount() {
        return (int) (money() / LOTTO_PRICE - this.manualCount.count());
    }

}
