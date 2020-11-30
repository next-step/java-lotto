package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(null))
                .withMessage(Validator.INPUT_NULL_MESSAGE);
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    public void inputEmptyTest() {

        // when, then
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(Validator.EMPTY))
                .withMessage(Validator.INPUT_EMPTY_MESSAGE);
    }
}
