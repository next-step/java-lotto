package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    @DisplayName("계산기에 null 또는 빈 문자열을 입력하면 IllegalArgumentException()이 발생한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  "})
    void 빈문자열_입력(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator(input);
        });
    }
    @DisplayName("사칙연산 기호가 아닌 경우 예외가 발생한다.")
    @Test
    void 사칙연산_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringCalculator("3 & 3");
        });
    }
}