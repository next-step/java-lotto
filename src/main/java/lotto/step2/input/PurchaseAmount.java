package lotto.step2.input;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("purchaseAmount must be greater than 0");
        }

        this.value = purchaseAmount;
    }

    public int getValue() {
        return value;
    }
}
