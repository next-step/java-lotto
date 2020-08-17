package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Message;

public class PurchaseAmount {
    private static final int PRICE_PER_LOTTO = 1000;
    private final int amount;

    private PurchaseAmount(int amount) {
        if (isNotValid(amount)) {
            throw new IllegalArgumentException(Message.EXCEPTION_FOR_PURCHASE_AMOUNT.of());
        }
        this.amount = amount;
    }

    private boolean isNotValid(int amount) {
        if (amount < PRICE_PER_LOTTO) {
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }

    public static PurchaseAmount of(int amount) {
        return new PurchaseAmount(amount);
    }

    public int getSize() {
        return this.amount / PRICE_PER_LOTTO;
    }
}
