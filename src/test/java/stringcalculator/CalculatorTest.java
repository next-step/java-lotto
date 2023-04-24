package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다.")
  @Test
  public void calculator_throwsException_nullOrEmptyInput() {
    assertThatThrownBy(() -> new Calculator(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Calculator(" ")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Calculator("")).isInstanceOf(IllegalArgumentException.class);
  }

}
