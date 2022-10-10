package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    @Test
    void 계산하기() {
        assertThat(StringCalculator.calculate(new String[]{"2", "+", "3", "*", "4", "/", "2"})).isEqualTo(10);
        assertThat(StringCalculator.calculate(new String[]{"10", "-", "7", "*", "4", "/", "2", "+", "8"})).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 예외 발생")
    void 입력값_빈값_OR_NULL(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.stringValidCheck(input);
        });
    }
}
