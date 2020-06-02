package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateCalculatorTest {

  @ParameterizedTest
  @CsvSource({
      "14000, 5000, 0.35",
      "14000, 2000000000, 142857.14"
  })
  void calculate(long expense, long income, double expected) {
    assertThat(ProfitRateCalculator.calculateByTwoDecimalPlaces(income, expense)).isEqualTo(expected);
  }
}
