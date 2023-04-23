package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
  @ParameterizedTest
  @CsvSource({
      "0, 0.0f",
      "1, 0.0f",
      "3, 0.05f",
      "4, 0.5f",
      "5, 15.0f",
      "6, 20000.0f"
  })
  void 수익률(int matchCount, float rateOfReturn) {
    LottoStatistics lottoStatistics = new LottoStatistics();
    lottoStatistics.increment(matchCount);
    assertThat(LottoPrize.getRateOfReturn(100000, lottoStatistics))
        .isEqualTo(rateOfReturn);
  }
}