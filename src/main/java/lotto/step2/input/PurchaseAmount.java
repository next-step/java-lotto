package lotto.step2.input;

import lotto.step2.service.LottoProgram;

public class PurchaseAmount {
    public static final int MAX_VALUE = 100_000_000;
    private final int value;

    public PurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount < LottoProgram.LOTTO_PRICE) {
            throw new IllegalArgumentException("purchaseAmount must be greater than lotto's price");
        }

        if (purchaseAmount > MAX_VALUE) {
            throw new IllegalArgumentException("purchaseAmount must be less than or equal to" + MAX_VALUE);
        }

        this.value = purchaseAmount;
    }

    public int getValue() {
        return value;
    }

    public int getMaxPassiveLottoCount() {
        return this.value / LottoProgram.LOTTO_PRICE;
    }
}
