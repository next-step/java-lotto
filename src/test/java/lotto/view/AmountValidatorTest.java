package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountValidatorTest {

    private Validator validator;

    @BeforeEach
    private void initAmountValidator() {

        // given
        validator = new AmountValidator();
    }

    @Test
    @DisplayName("입력한 값이 숫자인지 유효성 검사 테스트")
    public void inputNotNumericStringTest() {
        ValidatorUtils.assertValidation(validator, "숫자가 아닙니다", AmountValidator.NOT_NUMERIC_MESSAGE);
    }

    @Test
    @DisplayName("입력한 값이" + AmountValidator.MULTIPLE + "의 배수인지 테스트")
    public void inputNotMultipleNumberTest() {
        ValidatorUtils.assertValidation(validator, "1001", AmountValidator.NOT_MULTIPLE_MESSAGE);
    }
}
