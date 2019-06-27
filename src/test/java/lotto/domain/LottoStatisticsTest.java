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
        Rank.valueOf(4, true),
        Rank.valueOf(3, false));

    long lotteryPrize = 55000;
    int price = 14000;

    assertThat(LottoStatistics.profitRate(14000, LottoStatistics.statistics(ranks)))
        .isEqualTo(lotteryPrize/price);
  }
}
