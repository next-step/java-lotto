package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  @DisplayName("덧셈")
  void plusTest() {
    assertThat(Calculator.calculate("10 + 20 + 30")).isEqualTo(60);
  }

  @Test
  @DisplayName("뺄셈")
  void minusTest() {
    assertThat(Calculator.calculate("10 - 20 - 30")).isEqualTo(-40);
  }


}