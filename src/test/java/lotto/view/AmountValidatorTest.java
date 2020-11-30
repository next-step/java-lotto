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
    @DisplayName("유효한 값 입력 시 유효성 검사 성공 확인")
    public void validValueTest() {
        ValidatorUtils.assertDoesNotThrow(validator, "14000");
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 입력시 IllegalArgumentException 발생 테스트")
    public void inputNotNumericStringTest() {
        ValidatorUtils.assertValidation(validator, "숫자가 아닙니다", AmountValidator.NOT_NUMERIC_MESSAGE);
    }

    @Test
    @DisplayName("정해진 배수가 아닌 다른 값의 문자열을 입력시 IllegalArgumentException 발생 테스트")
    public void inputNotMultipleNumberTest() {
        ValidatorUtils.assertValidation(validator, "1001", AmountValidator.NOT_MULTIPLE_MESSAGE);
    }
}
