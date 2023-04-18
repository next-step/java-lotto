import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @Test
    void 빈_문자열일_때는_예외가_발생한다() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculator(""))
                .withMessage("문자열을 입력해주세요.");
    }

}
