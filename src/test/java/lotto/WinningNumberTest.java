package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

  @Test
  @DisplayName("일반적인 케이스 테스트")
  void testOf() {
    String input = "1, 2, 3, 4, 5, 6";
    WinningNumber.of(input);
  }

  @Test
  @DisplayName("범위를 벗어난 입력")
  void testOutOfRange() {
    String input = "1, 2, 3, 4, 5, 46";
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> WinningNumber.of(input)
    );
  }

  @Test
  @DisplayName("중복된 번호 입력")
  void testDuplicatedInput() {
    String input = "1, 2, 3, 4, 5, 5";
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> WinningNumber.of(input)
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
  @DisplayName("길이가 맞지 않는 입력")
  void testInvalidLength(String input) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> WinningNumber.of(input)
    );
  }
}
