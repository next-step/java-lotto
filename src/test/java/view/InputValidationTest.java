package view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidationTest {

  @Test
  void 입력_유효성_검사() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> InputValidation.validateInput(null))
        .withMessageContaining("입력 값이 없습니다.");

    assertThatIllegalArgumentException()
        .isThrownBy(() -> InputValidation.validateInput(""))
        .withMessageContaining("입력 값이 없습니다.");
  }
}