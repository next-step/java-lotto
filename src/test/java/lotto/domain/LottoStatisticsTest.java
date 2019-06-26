package lotto.domain;

import lotto.util.LottoStatistics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

  @Test
  void profitRate() {
    List<Rank> ranks = Arrays.asList(
        Rank.getInstance(4),
        Rank.getInstance(3));
    assertThat(LottoStatistics.profitRate(14000, LottoStatistics.statistics(ranks)))
        .isEqualTo(55/LottoStore.buyLottoCount(14000));
  }
}
