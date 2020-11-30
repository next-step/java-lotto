package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    private void initValidator() {

        // given
        validator = new Validator();
    }

    @Test
    @DisplayName("null 값 테스트")
    public void inputNullTest() {
        ValidatorUtils.assertValidation(validator, null, Validator.INPUT_NULL_MESSAGE);
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    public void inputEmptyTest() {
        ValidatorUtils.assertValidation(validator, Validator.EMPTY, Validator.INPUT_EMPTY_MESSAGE);
    }
}
