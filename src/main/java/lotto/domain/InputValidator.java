package lotto.domain;

import lotto.exception.InsufficientPriceException;
import lotto.exception.MisMatchPriceUnitException;

import static lotto.constant.Constant.PRICE_UNIT;

public class InputValidator {

    private static final int MIN_PRICE = 1000;
    private static final int ZERO = 0;

    public void validatePurchasePrice(int price) {
        validatePriceMinimumCondition(price);
        validatePriceUnitCondition(price);
    }

    private void validatePriceMinimumCondition(int price) {
        if (price < MIN_PRICE) {
            throw new InsufficientPriceException();
        }
    }

    private void validatePriceUnitCondition(int price) {
        if (price % PRICE_UNIT != ZERO) {
            throw new MisMatchPriceUnitException();
        }
    }
}
