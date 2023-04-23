package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
  private LottoStatistics lottoStatistics;

  @BeforeEach
  void beforeEach() {
    lottoStatistics = new LottoStatistics();
  }

  @Test
  void increase() {
    Map<Integer, Integer> expectedStatistics = new HashMap<>();
    expectedStatistics.put(3, 1);
    expectedStatistics.put(4, 0);
    expectedStatistics.put(5, 0);
    expectedStatistics.put(6, 0);

    lottoStatistics.increment(0);
    lottoStatistics.increment(3);
    assertThat(lottoStatistics.getStatistics())
        .isEqualTo(expectedStatistics);
  }
}