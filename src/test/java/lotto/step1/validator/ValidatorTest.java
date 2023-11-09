package lotto.step1.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 값이 null일 경우, IllegalArgumentException 예외가 발생한다.")
    void validateUserInputStringWithNull(String input) {
        //given, when, then
        assertThatThrownBy(() -> Validator.validateUserInputString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 null이 될 수 없습니다.");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력 값이 빈 공백 문자일 경우, IllegalArgumentException 예외가 발생한다.")
    void validateUserInputStringWithEmptyString(String input) {
        //given, when, then
        assertThatThrownBy(() -> Validator.validateUserInputString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 공백이 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "2 @ 4", "3 # 5", "3 $ 4", "4 % 2", "5 ^ 2", "6 & 2", "7 ~ 1", "1 < 2", "1 > 2"})
    @DisplayName("입력으로 사칙연산 기호가 아닌 기호가 들어온 경우, IllegalArgumentException 예외가 발생한다.")
    void validateUserInputStringWithNotOperator(String input) {
        //given, when, then
        assertThatThrownBy(() -> Validator.validateUserInputString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 사칙연산 기호만 입력이 가능합니다.");
    }
}
