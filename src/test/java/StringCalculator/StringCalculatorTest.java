package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = "1 + 1")
    @DisplayName("문자열 분리 기능 테스트")
    void split_string_test(String input) {
        List<String> strings = StringCalculator.calculate(input);

        assertThat(strings.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 또는 빈 입력값 예외 테스트")
    void isBlank_exception_test(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.INVALID_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = "1 ! 1")
    @DisplayName("연산자 예외 테스트")
    void operator_exception_test(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(StringCalculator.INVALID_OPERATOR_MESSAGE);
    }
}