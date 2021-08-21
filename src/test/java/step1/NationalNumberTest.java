package step1;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NationalNumberTest {

  @DisplayName("음수를 입력할 경우 예외가 발생한다")
  @Test
  void validate() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new NationalNumber("-1"));
  }

  @DisplayName("숫자가 이외의 값을 입력할 경우 예외가 발생한다.")
  @Test
  void validate_2() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new NationalNumber("A"));
  }
}