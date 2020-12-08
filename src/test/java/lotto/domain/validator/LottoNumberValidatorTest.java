package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

    private final Validator validator = new LottoNumberValidator();

    @Test
    @DisplayName("LowerBound 미만의 숫자가 입력되면 IllegalArgumentException 예외 발생")
    public void checkBound_BelowLowerBound_ExceptionThrown() {
        ValidatorUtils.assertValidation(validator, "0", LottoNumberValidator.OUT_BOUND_MESSAGE);
    }

    @Test
    @DisplayName("UpperBound 초과의 숫자가 입력되면 IllegalArgumentException 예외 발생")
    public void checkBound_OverUpperBound_ExceptionThrown() {
        ValidatorUtils.assertValidation(validator, "46", LottoNumberValidator.OUT_BOUND_MESSAGE);
    }
}