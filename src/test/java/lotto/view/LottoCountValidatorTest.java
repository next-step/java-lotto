package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountValidatorTest {

    private final LottoCountValidator validator = new LottoCountValidator();

    @Test
    @DisplayName("음수 입력 시 IllegalArgumentException 발생 테스트")
    public void checkPositive_NegativeNumber_ThrownException() {
        ValidatorUtils.assertValidation(validator, "-1", NumberValidator.NOT_POSITIVE_NUMBER);
    }
}