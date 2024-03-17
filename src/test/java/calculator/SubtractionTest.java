package calculator;

import calculator.domain.CalculatorQueue;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionTest {

  @ParameterizedTest
  @CsvSource({
      "10 - 3,7",
      "10 - 3 - 1,6",
      "10 - 3 - 1 - 2,4"
  })
  @DisplayName("뺄셈 기능 테스트")
  void subtractionTest(String given, int expected) {
    CalculatorQueue calculatorQueue = CalculatorQueue.of(given);
    assertThat(StringCalculator.calculate(calculatorQueue)).isEqualTo(expected);
  }
}
