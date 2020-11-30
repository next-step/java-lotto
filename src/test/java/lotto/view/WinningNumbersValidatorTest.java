package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    private Validator validator;

    @BeforeEach
    private void initWinningNumbersValidator() {

        // given
        validator = new WinningNumbersValidator();
    }

    @Test
    @DisplayName("입력한 값이 숫자 혹은 콤마인지 유효성 검사 테스트")
    public void inputNotNumericOrCommaStringTest() {
        ValidatorUtils.assertValidation(validator, "숫자 혹은 콤마가 아닙니다", WinningNumbersValidator.NOT_NUMBER_OR_COMMA_MESSAGE);
    }

    @Test
    @DisplayName("입력한 숫자가 정해진 사이즈보다 많습니다")
    public void outOfBoundTest() {
        ValidatorUtils.assertValidation(validator, "1,2,3,4,5,6,7", WinningNumbersValidator.SIZE_NOT_MATCH);
    }
}