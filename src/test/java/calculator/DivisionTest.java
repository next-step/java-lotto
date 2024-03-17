package calculator;

import calculator.domain.CalculatorQueue;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionTest {

  @ParameterizedTest
  @CsvSource({
      "100 / 5,20",
      "100 / 5 / 2,10",
      "100 / 5 / 2 / 2,5",
      "100 / 5 / 2 / 2 / 5,1",
  })
  @DisplayName("나눗셈 기능 테스트")
  void divisionTest(String given, int expected) {
    CalculatorQueue calculatorQueue = CalculatorQueue.of(given);
    assertThat(StringCalculator.calculate(calculatorQueue)).isEqualTo(expected);
  }
}
