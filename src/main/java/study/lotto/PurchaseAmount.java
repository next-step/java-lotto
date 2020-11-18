package study.lotto;

import study.lotto.core.Lotto;

public class PurchaseAmount {

    private final int amount;
    private final int numberOfPurchases;

    public PurchaseAmount(int amount) {
        if (amount < Lotto.PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("최소 한 장 이상의 로또를 구매해야 합니다.");
        }

        this.amount = amount;
        this.numberOfPurchases = amount / Lotto.PRICE_PER_LOTTO;
    }

    public int numberOfPurchases() {
        return numberOfPurchases;
    }
}
