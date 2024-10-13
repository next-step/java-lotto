package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    void testStringCalculator() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("입력이 비어있을 경우 예외발생")
    void testBlankString() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            StringCalculator.calculate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("더하기 계산 테스트")
    void testPlus() {
        assertThat(StringCalculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("빼기 계산 테스트")
    void testMinus() {
        assertThat(StringCalculator.calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 계산 테스트")
    void testProduct() {
        assertThat(StringCalculator.calculate("3 * 2")).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 계산 테스트")
    void testDivide() {
        assertThat(StringCalculator.calculate("4 / 2")).isEqualTo(2);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void testNotOperator() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate("2 x 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현 - 반복해서 계산해도 동일한 결과 반환")
    void testStringCalculatorRepeat() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능 구현 - 반복해서 계산해도 동일한 결과 반환")
    void testCalculatorRepeat() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
