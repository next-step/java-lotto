package lotto.step2.input;

public class UserInput {
    private final int purchaseAmount;

    public UserInput(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("purchaseAmount must be greater than 0");
        }
        
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
