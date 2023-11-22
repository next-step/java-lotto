package lotto.domain;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        validateUnit(purchaseAmount);
        return new PurchaseAmount(purchaseAmount);
    }

    private static void validateUnit(int purchaseAmount) {
        if (!isValidUnit(purchaseAmount)) {
            throw new IllegalArgumentException(String.format("구입 금액에는 %d원 단위의 숫자를 입력해야합니다.", LOTTO_PRICE));
        }
    }

    private static boolean isValidUnit(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }

    public double devideWith(int prizeAmount) {
        return (double) prizeAmount / purchaseAmount;
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
