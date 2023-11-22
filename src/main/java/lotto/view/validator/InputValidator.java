package lotto.view.validator;

import lotto.util.validator.StringValidator;

public class InputValidator {
    private static InputValidator inputValidator;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public void validatePurchaseAmount(String purchaseAmount, String target) {
        StringValidator.validateBlank(purchaseAmount, target);
        StringValidator.validateNumeric(purchaseAmount, target);
        StringValidator.validateIntegerRange(purchaseAmount, target);
        validatePositiveNumber(purchaseAmount, target);
    }

    private void validatePositiveNumber(String purchaseAmount, String target) {
        if (!isInRange(purchaseAmount)) {
            throw new IllegalArgumentException(String.format("%s에는 0보다 큰 숫자를 입력해야합니다.", target));
        }
    }

    private boolean isInRange(String value) {
        return Integer.parseInt(value) > 0;
    }
}
