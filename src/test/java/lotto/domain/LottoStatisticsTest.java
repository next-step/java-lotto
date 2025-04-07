package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStatisticsTest {

  private static final int PRICE_PER_LOTTO = 1000;

  @ParameterizedTest
  @CsvSource({
      "1, 0, 0, 0, 0, 0, 1, 2000000.0",
      "0, 1, 0, 0, 0, 0, 1, 30000.0",
      "0, 0, 1, 0, 0, 0, 1, 1500.0",
      "0, 0, 0, 1, 0, 0, 1, 50.0",
      "0, 0, 0, 0, 1, 0, 1, 5.0",
      "0, 0, 0, 0, 0, 1, 1, 0.0",
      "1, 0, 0, 0, 0, 0, 2, 1000000.0",
      "0, 0, 0, 0, 0, 0, 1, 0.0"
  })
  void 수익률_계산(int first, int second, int third, int fourth, int fifth, int miss, int tickets, double expected) {
    Map<PrizeRank, Integer> statistics = new HashMap<>();
    statistics.put(PrizeRank.FIRST, first);
    statistics.put(PrizeRank.SECOND, second);
    statistics.put(PrizeRank.THIRD, third);
    statistics.put(PrizeRank.FOURTH, fourth);
    statistics.put(PrizeRank.FIFTH, fifth);
    statistics.put(PrizeRank.MISS, miss);

    assertThat(new LottoStatistics(statistics, tickets, PRICE_PER_LOTTO).calculateProfitRate()).isEqualTo(expected);
  }
} 