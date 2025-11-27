package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitRateTest {

  @DisplayName("당첨금 수익률을 계산한다")
  @Test
  void calculateProfitRate() {
    ProfitRate profitRate = new ProfitRate(5000, new PurchaseAmount(2000));
    assertThat(profitRate.value()).isEqualTo((double) 5000 / 2000);
  }
}
