package calculator;

import calculator.domain.CalculatorQueue;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {

  @ParameterizedTest
  @CsvSource({
      "1 * 3,3",
      "1 * 2 * 3,6",
      "1 * 2 * 3 * 4,24",
      "1 * 2 * 3 * 4 * 5,120"
  })
  @DisplayName("곱셈 기능 테스트")
  void multiplicationTest(String given, int expected) {
    CalculatorQueue calculatorQueue = CalculatorQueue.of(given);
    assertThat(StringCalculator.calculate(calculatorQueue)).isEqualTo(expected);
  }
}
