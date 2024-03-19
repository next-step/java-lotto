package lotto.validator;

import lotto.exception.IllegalPurchaseAmountException;

public class InputValidator {

    private InputValidator() {

    }

    public static void validatePurchaseAmount(int amount) throws IllegalPurchaseAmountException {
        if (amount == 0) {
            throw new IllegalPurchaseAmountException(amount);
        }
    }

}
