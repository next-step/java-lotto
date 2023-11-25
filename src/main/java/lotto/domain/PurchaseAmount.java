package lotto.domain;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public double divideByPurchaseAmount(long prizeAmount) {
        return (double) prizeAmount / purchaseAmount;
    }

    private void validateUnit(int purchaseAmount) {
        if (!isValidUnit(purchaseAmount)) {
            throw new IllegalArgumentException(String.format("구입 금액에는 %d원 단위의 숫자를 입력해야합니다.", LOTTO_PRICE));
        }
    }

    private boolean isValidUnit(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
