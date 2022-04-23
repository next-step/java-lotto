package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

  @ParameterizedTest(name = "문자열을 받아 사칙연산을 할 수 있다.")
  @CsvSource({"2 + 3 * 4 / 2, 10", "1 + 1, 2", "1 - 1, 0"})
  void calculate(String input, Integer result) {
    Calculator calculator = new Calculator(input);
    assertThat(calculator.calculate()).isEqualTo(result);
  }

  @ParameterizedTest(name = "null 또는 empty string을 입력하면 예외가 발생한다.")
  @NullAndEmptySource
  void create(String input) {
    assertThatThrownBy(() -> new Calculator(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest(name = "유효하지 않은 계산식을 입력하면 예외가 발생한다.")
  @ValueSource(strings = {"1 +1", "1+1", "1 + 3 +", "zzz", "2 + . 3"})
  void calculate_invalid_formula(String input) {
    assertThatThrownBy(() -> new Calculator(input).calculate())
        .isInstanceOf(IllegalArgumentException.class);
  }
}
