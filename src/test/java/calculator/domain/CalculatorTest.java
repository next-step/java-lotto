package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.InvalidFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  @ParameterizedTest
  @DisplayName("계산식의 결과가 정확한지 확인")
  @CsvSource(value = {"|0", "1 + 1|2", "2 + 3 * 4 / 2|10", "1 - 3 * 1 / 1|-2",
      "0 * 1 + 20 - 40|-20"}, delimiter = '|')
  void calculate(String input, long result) {
    Calculator calculator = new Calculator();

    assertThat(calculator.calc(input)).usingRecursiveComparison().isEqualTo(new Number(result));
  }

  @ParameterizedTest
  @DisplayName("계산식이 문법에 맞지 않을 경우 에러 발생")
  @ValueSource(strings = {"123 * + 1", "55 1", "1 + 1 1 + 2", "1 * 1 * 20 * *"})
  void invalidFormula(String input) {
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> {
      calculator.calc(input);
    }).isInstanceOf(InvalidFormulaException.class);
  }
}
