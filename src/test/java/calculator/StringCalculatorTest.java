package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringCalculatorTest {


  @DisplayName("null 입력값인 경우 예외를 던진다")
  @ParameterizedTest
  @NullSource
  public void validateNullInput(String input) {
    assertThatNullPointerException().isThrownBy(() -> StringCalculator.calculate(input));
  }

  @DisplayName("빈 문자열인 경우 예외를 던진다")
  @ParameterizedTest
  @EmptySource
  public void validateEmptyInput(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(input))
        .withMessage(StringCalculator.EMPTY_EQUATION_MESSAGE);
  }

  @DisplayName("문자열 계산기 덧셈")
  @ParameterizedTest
  @CsvSource(value = {"1 + 2=3", "1 + 2 + 3=6"}, delimiter = '=')
  public void add(String left, String expected) {
    assertThat(StringCalculator.calculate(left)).isEqualTo(Number.createNumber(expected));
  }

  @DisplayName("문자열 계산기 뺄셈")
  @ParameterizedTest
  @CsvSource(value = {"0 - 1=-1", "2 - 1=1"}, delimiter = '=')
  public void subtract(String left, String expected) {
    assertThat(StringCalculator.calculate(left)).isEqualTo(Number.createNumber(expected));
  }

  @DisplayName("문자열 계산기 곱셈")
  @ParameterizedTest
  @CsvSource(value = {"0 * 1=0", "1 * 2=2"}, delimiter = '=')
  public void multiply(String left, String expected) {
    assertThat(StringCalculator.calculate(left)).isEqualTo(Number.createNumber(expected));
  }

  @DisplayName("문자열 계산기 나눗셈")
  @ParameterizedTest
  @CsvSource(value = {"0 / 1=0", "1 / 2=0", "2 / 1=2"}, delimiter = '=')
  public void divide(String left, String expected) {
    assertThat(StringCalculator.calculate(left)).isEqualTo(Number.createNumber(expected));
  }

  @DisplayName("0으로 나눈경우 예외를 던진다")
  @Test
  public void divideByZero() {
    assertThatExceptionOfType(ArithmeticException.class).isThrownBy(
        () -> StringCalculator.calculate("1 / 0"));
  }

  @DisplayName("문자열 계산기 사칙연산 입출력값 검증")
  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2=10", "1 / 2 * 4 + 2 - 1=1"}, delimiter = '=')
  public void calculate(String left, String expected) {
    assertThat(StringCalculator.calculate(left)).isEqualTo(Number.createNumber(expected));
  }

  @DisplayName("사칙연산 기호가 아닌 경우 예외 던짐")
  @Test
  public void notOperator() {
    assertThatIllegalArgumentException().isThrownBy(
            () -> StringCalculator.calculate("2 ^ 3"))
        .withMessageContaining("지원되지 않는 기호입니다");
  }
}
