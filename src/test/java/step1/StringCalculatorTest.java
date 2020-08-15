package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.StringCalculator;

class StringCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void givenEmpty_whenAdd_thenReturnZero(String sentence) {
    assertThat(StringCalculator.add(sentence)).isZero();
  }

  @DisplayName("문자열 숫자 하나만 입력")
  @Test
  void givenOneNumberAsString() {
    assertThat(StringCalculator.add("4")).isEqualTo(4);
  }

  @Test
  void givenCommaSeparator() {
    assertThat(StringCalculator.add("1,2")).isEqualTo(3);
  }

  @Test
  void givenColonSeparator() {
    assertThat(StringCalculator.add("1:2")).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3", "1,2:3"})
  void givenSeparator(String sentence) {
    assertThat(StringCalculator.add(sentence)).isEqualTo(6);
  }

  @Test
  void givenCustomSeparator() {
    assertThat(StringCalculator.add("//;\n1;2;3")).isEqualTo(6);
  }

  @DisplayName("음수 문자열 숫자 하나만 입력")
  @Test
  void givenNegativeOneNumberAsString() {
    assertThatThrownBy(() -> StringCalculator.add("-1")).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("음수 문자열 숫자 포함")
  @Test
  void givenContainNegativeNumberAsString() {
    assertThatThrownBy(() -> StringCalculator.add("1,2,-3")).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("숫자 이외의 값 포함")
  @Test
  void givenContainNegativeValue() {
    assertThatThrownBy(() -> StringCalculator.add("1,2:c")).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("0 문자열 숫자 포함")
  @Test
  void givenContainZero() {
    assertThat(StringCalculator.add("1,2:0")).isEqualTo(3);
  }

}
