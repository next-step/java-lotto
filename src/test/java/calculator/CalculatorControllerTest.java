package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorControllerTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력_값이_null이거나_빈_공백_문자일_경우_예외_테스트(final String input) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorController.validateInput(input));
    }
}
