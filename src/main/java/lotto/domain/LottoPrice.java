package lotto.domain;

import lotto.domain.exception.ErrorMessage;
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
            int insufficientPrice = LOTTO_PRICE - purchasePrice;
            throw new NotValidLottoPriceException(insufficientPrice + ErrorMessage.NOT_VALID_PRICE.getMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
