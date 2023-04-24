package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다.")
  @Test
  public void calculator_throwsException_nullOrEmptyInput() {
    assertThatThrownBy(() -> new Calculator(null)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Calculator(" ")).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Calculator("")).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("숫자가 와야할 순서에 숫자가 아닌 문자를 만나면 IllegalArgumentException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + +", "+ 1 +", "+ + 1"})
  public void calculate_throwException_outOfOrderNumber(String input) {
    Calculator calculator = new Calculator(input);

    assertThatThrownBy(() -> calculator.calculate()).isInstanceOf(IllegalArgumentException.class);
  }

}
