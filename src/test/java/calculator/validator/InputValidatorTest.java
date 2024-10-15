package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

  @DisplayName("null 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullThrowsException() {

    assertThatThrownBy(() -> {
      InputValidator.validateInput(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("빈문자열 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullStringThrowsException() {

    assertThatThrownBy(() -> {
      InputValidator.validateInput("");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}