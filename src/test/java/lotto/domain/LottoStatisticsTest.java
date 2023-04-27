package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static lotto.domain.MatchNumbersCount.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
  private LottoStatistics statistics;

  @BeforeEach
  void setUp() {
    HashMap<MatchNumbersCount, Integer> statistics = new HashMap<>();
    statistics.put(MATCH_0, 0);
    statistics.put(MATCH_1, 0);
    statistics.put(MATCH_2, 0);
    statistics.put(MATCH_3, 5);
    statistics.put(MATCH_4, 0);
    statistics.put(MATCH_5, 0);
    statistics.put(MATCH_6, 0);
    this.statistics = new LottoStatistics(statistics);
  }

  @Test
  void 수익률() {
    assertThat(statistics.getRateOfReturn()).isEqualTo(5.0f);
  }
}