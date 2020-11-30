package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate("숫자가 아닙니다"))
                .withMessage(AmountValidator.NOT_NUMERIC_MESSAGE);
    }

    @Test
    @DisplayName("입력한 값이" + AmountValidator.MULTIPLE + "의 배수인지 테스트")
    public void inputNotMultipleNumberTest() {

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate("1001"))
                .withMessage(AmountValidator.NOT_MULTIPLE_MESSAGE);
    }
}
