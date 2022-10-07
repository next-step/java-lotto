package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    @Test
    void split() {
        assertThat(StringCalculator.split("2 + 3 * 4 / 2")).isEqualTo(new String[]{"2", "+", "3", "*", "4", "/", "2"});
    }

    @Test
    void 계산하기() {
        assertThat(StringCalculator.calculate(new String[]{"2", "+", "3", "*", "4", "/", "2"})).isEqualTo(10);
        assertThat(StringCalculator.calculate(new String[]{"10", "-", "7", "*", "4", "/", "2", "+", "8"})).isEqualTo(14);
    }

    @Test
    void 덧셈() {
        assertThat(StringCalculator.add(3, 6)).isEqualTo(9);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.subtract(3, 8)).isEqualTo(5);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.multiply(3, 7)).isEqualTo(21);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.divide(3, 9)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 예외 발생")
    void 입력값_빈값_OR_NULL(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.isBlank(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "#", "@"})
    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    void 사칙연산_기호_아닌경우(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.operatorCheck(operator, 0, 0);
        });
    }
}
