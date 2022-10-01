package Step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MathEquationValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 공백 문자열인 경우 IllegalArgumentException 발생")
    void exceptionTest1(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> MathEquationValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "*", "="})
    @DisplayName("사칙 연산 기호가 아닌 경우 IllegalArgumentException")
    void exceptionTest2(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> MathEquationValidator.validate(input));
    }

}
