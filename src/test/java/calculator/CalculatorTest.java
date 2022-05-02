package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

  @Test
  @DisplayName("덧셈")
  void plusTest() {
    assertThat(Calculator.calculate("10 + 20 + 30")).isEqualTo(60);
  }

  @Test
  @DisplayName("뺄셈")
  void minusTest() {
    assertThat(Calculator.calculate("10 - 20 - 30")).isEqualTo(-40);
  }

  @Test
  @DisplayName("곱하기")
  void timesTest() {
    assertThat(Calculator.calculate("10 * 20 * 30")).isEqualTo(6000);
  }

  @Test
  @DisplayName("나누기")
  void divideTest() {
    assertThat(Calculator.calculate("10 + 20 / 3")).isEqualTo(10);
  }

  @Test
  @DisplayName("복합 사칙 연산")
  void complexTest() {
    assertThat(Calculator.calculate("2 + 3 * 4 / 2 - 5")).isEqualTo(5);
  }

  @Test
  @DisplayName("입력값이 null 일 경우 IllegalArgumentException throw")
  void givenNull_ShouldIllegalArgumentExceptionThrow() {
    assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(null));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " ", "  "})
  @DisplayName("입력값이 빈 문자열일 경우 IllegalArgumentException throw")
  void givenEmptyString_ShouldIllegalArgumentExceptionThrow() {
    assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(""));
  }

  @Test
  @DisplayName("사칙연산 기호가 아닐 경우 IllegalArgumentException throw")
  void givenNonOperator_ShouldIllegalArgumentExceptionThrow() {
    assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("2 % 6"));
  }

}
