package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoPriceException;

public class Money {

    private static final int LOTTO_PRICE = 1_000;
    private int purchasePrice;

    private Money(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public static Money from(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return new Money(purchasePrice);
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            int insufficientPrice = LOTTO_PRICE - purchasePrice;
            throw new NotValidLottoPriceException(insufficientPrice + ErrorMessage.NOT_VALID_PRICE.getMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
