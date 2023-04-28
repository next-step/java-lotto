package study.stringcalculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.stringcalculator.domain.InputValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateServiceTest {

  CalculateService calculateService = new CalculateService();

  @DisplayName("숫자가 와야할 순서에 숫자가 아닌 문자를 만나면 IllegalArgumentException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + +", "+ 1 +", "+ + 1"})
  public void calculate_throwException_outOfOrderNumber(String input) {
    InputValue inputValue = new InputValue(input);

    assertThatThrownBy(() -> calculateService.calculate(inputValue))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산이 와야할 순서에 사칙연산이 아닌 문자를 만나면 IllegalArgumentException을 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"1 1 1", "1 ? 1", "1 ^ 1"})
  public void calculate_throwException_outOfOrderOperator(String input) {
    InputValue inputValue = new InputValue(input);

    assertThatThrownBy(() -> calculateService.calculate(inputValue))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산으로 끝나는 식은 IllegalArgumentException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = {"1 +", "1 -", "1 *"})
  public void calculate_throwException_EndOperator(String input) {
    InputValue inputValue = new InputValue(input);

    assertThatThrownBy(() -> calculateService.calculate(inputValue))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사칙연산을 정상적으로 수행한다.")
  @ParameterizedTest
  @CsvSource({"1 + 1,2", "2 - 1,1", "2 * 2,4", "4 / 3,1", "3 / 5 + 100,100", "1 + 1 + 1,3"})
  public void calculate_Result(String input, int result) {
    InputValue inputValue = new InputValue(input);

    assertThat(calculateService.calculate(inputValue)).isEqualTo(result);
  }
}
