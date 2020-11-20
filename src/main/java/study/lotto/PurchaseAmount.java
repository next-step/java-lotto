package study.lotto;

import study.lotto.core.Lotto;

public class PurchaseAmount {

    private final int amount;
    private final int numberOfPurchases;
    private final int numberOfManualLotto;


    public PurchaseAmount(int amount, int numberOfManualLotto) {
        if (amount < Lotto.PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("최소 한 장 이상의 로또를 구매해야 합니다.");
        }

        this.amount = amount;
        this.numberOfPurchases = amount / Lotto.PRICE_PER_LOTTO;
        this.numberOfManualLotto = numberOfManualLotto;
    }

    public int numberOfPurchases() {
        return numberOfPurchases;
    }

    public int getNumberOfManualLotto() {
        return numberOfManualLotto;
    }

    public int getNumberOfAutoLotto() {
        return numberOfPurchases - numberOfManualLotto;
    }

}
