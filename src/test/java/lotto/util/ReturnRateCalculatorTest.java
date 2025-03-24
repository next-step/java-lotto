package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReturnRateCalculatorTest {

  @DisplayName("수익률 계산")
  @Test
  void testCalculate() {
    assertThat(ReturnRateCalculator.calculate(14000, 5000)).isEqualTo(0.35);
  }
}
