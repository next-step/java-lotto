package step2.model;

public class Money {

    private static final int EACH_LOTTO_MONEY = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public void purchaseManualLotto(int manualLottoCount) {
        validateExceededPurchaseAmount(manualLottoCount);
        money -= manualLottoCount * EACH_LOTTO_MONEY;
    }

    private void validateExceededPurchaseAmount(int manualLottoCount) {
        if (money < manualLottoCount * EACH_LOTTO_MONEY) {
            throw new IllegalArgumentException("제시한 금액보다 수동 로또 구매 금액이 더 큽니다.");
        }
    }

    public int determineLottoPurchaseCount() {
        return money / EACH_LOTTO_MONEY;
    }
}
