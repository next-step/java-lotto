package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 계산기 테스트")
class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 공백인 경우 예외를 던진다")
    void validateInputNullAndEmpty_null이나빈문자열(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateInputFormula(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "^", "@"})
    @DisplayName("입력값이 사칙연산이 아닌 경우 예외를 던진다")
    void validateArithmeticFormula_연산자_검증(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateArithmeticFormula(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
