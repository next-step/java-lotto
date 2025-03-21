package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {""})
  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 경우 IllegalArgumentException 예외를 던진다.")
  void checkInput_isNull_or_isEmpty(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(input));
  }

  @Test
  @DisplayName("덧셈")
  void addition() {
    assertThat(StringCalculator.calculate("2 + 3")).isEqualTo(5);
  }

  @Test
  @DisplayName("뺄셈")
  void subtraction() {
    assertThat(StringCalculator.calculate("2 - 3")).isEqualTo(-1);
  }

  @Test
  @DisplayName("곱셈")
  void multiplication() {
    assertThat(StringCalculator.calculate("2 * 3")).isEqualTo(6);
  }

  @Test
  @DisplayName("나눗셈")
  void division() {
    assertThat(StringCalculator.calculate("6 / 3")).isEqualTo(2);
  }

  @Test
  @DisplayName("입력 값에 따라 계산 순서가 결정된다.")
  void calculate_by_inputOrder() {
    assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
  }

  @Test
  @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 예외를 던진다.")
  void checkInput_isNotOperator() {
    assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("2 & 3"));
  }

}
