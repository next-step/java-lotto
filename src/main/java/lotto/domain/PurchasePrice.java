package lotto.domain;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        assertValidPrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int countPurchasableLotto() {
        return purchasePrice / Lotto.PRICE;
    }

    private void assertValidPrice(int price) {
        String message = "[유저] 올바른 가격을 입력해주세요.";
        if (price < 0 || price % Lotto.PRICE > 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
