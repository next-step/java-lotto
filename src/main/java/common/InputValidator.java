package common;

import common.message.ErrorMessage;

public class InputValidator {

    private static final int MINIMUM_PRICE = 0;

    public static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < MINIMUM_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }
}
