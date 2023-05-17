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
        if (manuallyPurchaseAmount > purchasableAmount) {
            throw new IllegalArgumentException("수동으로 구매 가능한 수량을 초과했습니다.");
        }
        return new PurchaseAmount(manuallyPurchaseAmount, purchasableAmount - manuallyPurchaseAmount);
    }

    public int getManuallyPurchaseAmount() {
        return manuallyPurchaseAmount;
    }

    public int getAutomaticallyPurchaseAmount() {
        return automaticallyPurchaseAmount;
    }
}
