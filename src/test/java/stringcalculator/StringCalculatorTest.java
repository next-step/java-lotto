package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @DisplayName("덧셈 기능 테스트")
    @Test
    void add() {
        assertThat(StringCalculator.calculate("1 + 2 + -3")).isEqualTo(0);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    void minus() {
        assertThat(StringCalculator.calculate("10 - 2 - -3")).isEqualTo(11);
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    void multiply() {
        assertThat(StringCalculator.calculate("100 * 2 * -3")).isEqualTo(-600);
    }

    @DisplayName("나눗셈 기능 테스트")
    @Test
    void divide() {
        assertThat(StringCalculator.calculate("100 / 2 / -2")).isEqualTo(-25);
    }

    @DisplayName("모든 연산 포함하는 계산 기능 테스트")
    @Test
    void all_operator() {
        assertThat(StringCalculator.calculate("100 / 10 + 60 - 20 * 4")).isEqualTo(200);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void empty_input(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자, 숫자가 아닐 경우 테스트")
    @Test
    void null_empty_input() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("10   * 3"));
    }

    @DisplayName("피연산자 입력 값이 숫자가 아닐 경우 테스트")
    @Test
    void non_number_input() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("T + D + D"));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    @Test
    void non_arithmetic_input() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("100 / 10 a 60 B 20 ㅁ 4"));
    }
}
