package lotto;

import lotto.domain.exception.NotValidLottoPriceException;

public class LottoPrice {

    private static final int LOTTO_PRICE = 1_000;
    private int purchasePrice;

    public LottoPrice(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new NotValidLottoPriceException(LOTTO_PRICE - purchasePrice);
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
