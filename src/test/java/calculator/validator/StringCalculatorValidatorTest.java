package calculator.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class StringCalculatorValidatorTest {

    @ParameterizedTest(name = "유효성 검사 실패 - input: {0}")
    @NullSource
    @ValueSource(strings = {"", " ", "  ", " 1 + 1", "1 + 1 ", "1 + 1 -", "1 & 1"})
    void invalidInput(String input) {
        // given & when & given
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculatorValidator.validateOrThrow(input))
                                            .withMessageStartingWith("입력값이 유효하지 않습니다");
    }

    @ParameterizedTest(name = "유효성 검사 성공 - input: {0}")
    @ValueSource(strings = {"1", "1 + 1", "1 + 1 - 1 * 1 / 1"})
    void validInput(String input) {
        // given & when & given
        assertThatNoException().isThrownBy(() -> StringCalculatorValidator.validateOrThrow(input));
    }
}
