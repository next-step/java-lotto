package lotto.step2.input;

public class UserInput {
    private final PurchaseAmount purchaseAmount;
    private final PassiveLottoCount passiveLottoCount;

    public UserInput(final int purchaseAmount, final int passiveLottoCount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.passiveLottoCount = new PassiveLottoCount(passiveLottoCount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getValue();
    }

    public int getPassiveLottoCount() {
        return passiveLottoCount.getValue();
    }
}
