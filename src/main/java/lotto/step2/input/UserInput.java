package lotto.step2.input;

public class UserInput {
    private final PurchaseAmount purchaseAmount;

    public UserInput(final int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getValue();
    }
}
