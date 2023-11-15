package lotto.step2.input;

public class UserInput {
    private final PurchaseAmount purchaseAmount;
    private final PassiveLottoCount passiveLottoCount;

    public UserInput(final PurchaseAmount purchaseAmount, final PassiveLottoCount passiveLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.passiveLottoCount = passiveLottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getValue();
    }

    public int getPassiveLottoCount() {
        return passiveLottoCount.getValue();
    }
}
