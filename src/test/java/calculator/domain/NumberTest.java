package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

  @ParameterizedTest
  @CsvSource({
      "10, PLUS, 5, 15",
      "10, MINUS, 3, 7",
      "4, MULTIPLY, 5, 20",
      "10, DIVIDE, 2, 5"
  })
  void applyTest(int a, Operator operator, int b, int expected) {
    calculator.domain.Number num1 = new calculator.domain.Number(a);
    calculator.domain.Number num2 = new calculator.domain.Number(b);
    calculator.domain.Number result = num1.apply(operator, num2);

    assertThat(result.getValue()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(strings = {"abc", "12.34", "", "1a2", "!@#"})
  void throwExceptionWhenInvalidString(String invalidInput) {
    assertThatThrownBy(() -> new Number(invalidInput))
        .isInstanceOf(NumberFormatException.class);
  }
}