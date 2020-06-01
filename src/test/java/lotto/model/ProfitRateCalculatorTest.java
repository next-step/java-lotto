package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateCalculatorTest {

  @ParameterizedTest
  @CsvSource({
      "14000, 5000, 0.35"
  })
  void calculate(int expense, int income, double expected) {
    assertThat(ProfitRateCalculator.calculate(income, expense)).isEqualTo(expected);
  }
}
