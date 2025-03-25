package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("입력 값이 빈 공백 하나일 경우 테스트")
    @Test
    void empty_input() {
        assertThatThrownBy(() -> StringCalculator.calculate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자, 숫자가 아닐 경우 테스트")
    @Test
    void null_empty_input() {
        assertThatThrownBy(() -> StringCalculator.calculate("10   * 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("피연산자 입력 값이 숫자가 아닐 경우 테스트")
    @Test
    void non_number_input() {
        assertThatThrownBy(() -> StringCalculator.calculate("T + D + D"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 테스트")
    @Test
    void non_arithmetic_input() {
        assertThatThrownBy(() -> StringCalculator.calculate("100 / 10 a 60 B 20 ㅁ 4"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
