package lotto.domain;

import lotto.exception.ManualCountException;
import lotto.exception.MinimumAmountException;

public class Money {

    private static final long LOTTO_PRICE = 1000l;
    private final int purchaseAmount;
    private final int manualCount;

    private Money(int purchaseAmount, int manualCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualCount = manualCount;
    }

    public static Money of(int purchaseAmount, int manualCount) {
        valid(purchaseAmount, manualCount);
        return new Money(purchaseAmount, manualCount);
    }

    private static void valid(int purchaseAmount, int manualCount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new MinimumAmountException(LOTTO_PRICE);
        }

        if (purchaseAmount / LOTTO_PRICE < manualCount) {
            throw new ManualCountException();
        }
    }
}
