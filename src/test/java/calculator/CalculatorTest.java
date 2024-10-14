package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @DisplayName("null 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullThrowsException() {

    Assertions.assertThatThrownBy(() -> {
      Calculator.calculate(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("빈문자열 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullStringThrowsException() {

    Assertions.assertThatThrownBy(() -> {
      Calculator.calculate("");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}