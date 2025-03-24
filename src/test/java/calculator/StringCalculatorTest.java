package calculator;

import static calculator.StringCalculator.isBlank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @Test
  void 덧셈() {
    assertThat(StringCalculator.add(1, 2)).isEqualTo(3);
  }

  @Test
  void 뺄셈() {
    assertThat(StringCalculator.subtract(2, 1)).isEqualTo(1);
  }

  @Test
  void 곱셈() {
    assertThat(StringCalculator.multiply(1, 2)).isEqualTo(2);
  }

  @Test
  void 나눗셈() {
    assertThat(StringCalculator.divide(6, 3)).isEqualTo(2);
  }

  @Test
  void 입력값이_null일_경우_예외발생() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> isBlank(null));
  }

  @Test
  void 입력값이_빈_공백_문자열일_경우_예외발생() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> isBlank(" "))
        .withMessageMatching("입력 값은 null이거나 비어 있을 수 없습니다.");
  }

  @Test
  void 문자열_입력시_연산결과_출력() {
    assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
  }

  @Test
  void 사칙연산이_아닌_경우_예외_출력() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> StringCalculator.calculate("2 + 3 & 4 / 2"));
  }
}