package calculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

  @DisplayName("숫자형식의 값이 아니거나 null 또는 빈 문자열은 예외를 던짐")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"👍", "ab"})
  void constructorThrowsNumberFormatException(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(
        () -> Number.from(input));
  }
}