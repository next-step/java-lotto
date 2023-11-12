package lotto.domain;

import lotto.exception.InsufficientPriceException;

public class InputValidator {

    private static final int MIN_PRICE = 1000;

    public void validatePurchasePrice(int price) {
        validatePriceMinimumCondition(price);

    }

    private static void validatePriceMinimumCondition(int price) {
        if (price < MIN_PRICE) {
            throw new InsufficientPriceException();
        }
    }
}
