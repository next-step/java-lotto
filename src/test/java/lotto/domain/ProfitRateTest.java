package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRateTest {

  @ParameterizedTest
  @DisplayName("이익이 정확이 계산되는지 확인")
  @CsvSource(value = {"10|10000|1", "10|5000|0.5", "100|5000|0.05"}, delimiter = '|')
  void profit(int gameCount, int reword, double profit) {
    ProfitRate profitRate = new ProfitRate(gameCount, reword);

    assertThat(profitRate.getValue()).isEqualTo(profit);
  }
}