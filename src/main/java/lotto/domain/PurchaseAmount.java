package lotto.domain;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;

    private final int manuallyPurchaseAmount;
    private final int automaticallyPurchaseAmount;

    private PurchaseAmount(int manuallyPurchaseAmount, int automaticallyPurchaseAmount) {
        this.manuallyPurchaseAmount = manuallyPurchaseAmount;
        this.automaticallyPurchaseAmount = automaticallyPurchaseAmount;
    }

    public static PurchaseAmount of(int price, int manuallyPurchaseAmount) {
        int purchasableAmount = price / LOTTO_PRICE;
        validateInput(price, manuallyPurchaseAmount, purchasableAmount);
        return new PurchaseAmount(manuallyPurchaseAmount, purchasableAmount - manuallyPurchaseAmount);
    }

    private static void validateInput(int price, int manuallyPurchaseAmount, int purchasableAmount) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1000원 단위로 입력되어야 합니다.");
        }
        if (manuallyPurchaseAmount > purchasableAmount) {
            throw new IllegalArgumentException("수동으로 구매 가능한 수량을 초과했습니다.");
        }
    }

    public int getManuallyPurchaseAmount() {
        return manuallyPurchaseAmount;
    }

    public int getAutomaticallyPurchaseAmount() {
        return automaticallyPurchaseAmount;
    }
}
