package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRateTest {

  @Test
  void testProfitRate() {
    assertThat(new ProfitRate(2000000000, 1000))
        .isEqualTo(new ProfitRate((float) 2000000000 / 1000));
  }

  @ParameterizedTest
  @CsvSource({"1,이익", "0.999,손해"})
  void testExplanation(float profit, String value) {
    assertThat(new ProfitRate(profit).toString()).contains(value);
  }

  @Test
  void divisionByZeroThrowException() {
    assertThatThrownBy(() -> new ProfitRate(1000, 0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("구매 금액은 0보다 커야 합니다");
  }

  @Test
  void negativeWinningPrizeThrowException() {
    assertThatThrownBy(() -> new ProfitRate(-1000, 1000))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("당첨 금액은 0 이상이어야 합니다");
  }

}