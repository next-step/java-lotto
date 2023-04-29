package lotto.domain;

public class ClientLottoPurchasePrice {

    private static final int MIN_PURCHASABLE_PRICE = 1000;

    private static final String INVALID_PRICE_MSG = "로또 최소 구매 금액은 1000원 이상입니다.";

    private final int purchasePrice;

    public ClientLottoPurchasePrice(int purchasePrice) {
        if(invalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.purchasePrice = purchasePrice;
    }

    private boolean invalidPrice(int purchasePrice) {
        return purchasePrice < MIN_PURCHASABLE_PRICE;
    }


}
