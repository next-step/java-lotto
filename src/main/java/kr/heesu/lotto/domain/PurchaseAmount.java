package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

public class PurchaseAmount {
    private static final int PRICE_PER_LOTTO = 1000;

    private final int amount;

    private PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount of(int amount) {
        validationCheck(amount);
        return new PurchaseAmount(amount);
    }

    public static PurchaseAmount of(String inputAmount) {
        int amount = Integer.parseInt(inputAmount);
        validationCheck(amount);

        return new PurchaseAmount(amount);
    }

    private static void validationCheck(int amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getSize() {
        return amount / PRICE_PER_LOTTO;
    }
}
