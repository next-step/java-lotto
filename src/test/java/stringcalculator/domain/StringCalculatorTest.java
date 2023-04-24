package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다.")
  @Test
  public void calculator_throwsException_nullOrEmptyInput() {
    assertThatThrownBy(() -> new StringCalculator(null))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new StringCalculator(" "))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new StringCalculator("")).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("숫자가 와야할 순서에 숫자가 아닌 문자를 만나면 IllegalArgumentException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + +", "+ 1 +", "+ + 1"})
  public void calculate_throwException_outOfOrderNumber(String input) {
    StringCalculator calculator = new StringCalculator(input);

    assertThatThrownBy(() -> calculator.calculate()).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산이 와야할 순서에 사칙연산이 아닌 문자를 만나면 IllegalArgumentException을 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"1 1 1", "1 ? 1", "1 ^ 1"})
  public void calculate_throwException_outOfOrderOperator(String input) {
    StringCalculator calculator = new StringCalculator(input);

    assertThatThrownBy(() -> calculator.calculate()).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산을 정상적으로 수행한다.")
  @ParameterizedTest
  @CsvSource({"1 + 1,2", "2 - 1,1", "2 * 2,4", "4 / 3,1", "3 / 5 + 100,100", "1 + 1 + 1,3"})
  public void calculate_Result(String input, int result) {
    StringCalculator calculator = new StringCalculator(input);

    assertThat(calculator.calculate()).isEqualTo(result);
  }
}
