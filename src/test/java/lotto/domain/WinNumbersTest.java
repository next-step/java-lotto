package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class WinNumbersTest {

  @DisplayName("null 또는 빈 우승번호는 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void winNumbers(String winNumbers) {
    assertThatIllegalArgumentException().isThrownBy(() -> new WinNumbers(winNumbers));
  }
}