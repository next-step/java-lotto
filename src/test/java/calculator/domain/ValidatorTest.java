package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("문자열 계산기 테스트")
class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 공백인 경우 예외를 던진다")
    void test_validateInputNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> Validator.validateInputNullAndEmptyWithThrow(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}