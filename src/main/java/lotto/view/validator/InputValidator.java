package lotto.view.validator;

import java.util.List;
import lotto.util.converter.Converter;
import lotto.util.validator.GeneralValidator;
import lotto.util.validator.StringValidator;

public class InputValidator {
    public static final String LOTTO_NUMBER_SEPARATOR = ",";
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

    public void validateLotto(String lotto, String target) {
        StringValidator.validateBlank(lotto, target);
        GeneralValidator.validateDuplicateSubstring(LOTTO_NUMBER_SEPARATOR, lotto, target);
        GeneralValidator.validateStartSubstring(LOTTO_NUMBER_SEPARATOR, lotto, target);
        GeneralValidator.validateEndSubstring(LOTTO_NUMBER_SEPARATOR, lotto, target);

        validateLottoNumber(Converter.splitToList(LOTTO_NUMBER_SEPARATOR, lotto), target);
    }

    public void validateBonusBall(String bonusBall, String target) {
        StringValidator.validateBlank(bonusBall, target);
        StringValidator.validateNumeric(bonusBall, target);
        StringValidator.validateIntegerRange(bonusBall, target);
    }

    private void validateLottoNumber(List<String> lottoNumbers, String target) {
        lottoNumbers.forEach(lottoNumber -> StringValidator.validateNumeric(lottoNumber.trim(), target));
        lottoNumbers.forEach(lottoNumber -> StringValidator.validateIntegerRange(lottoNumber.trim(), target));
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
