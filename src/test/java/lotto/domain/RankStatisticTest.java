package lotto.domain;

import static lotto.domain.model.Rank.FAILURE;
import static lotto.domain.model.Rank.FIFTH;
import static lotto.domain.model.Rank.FIRST;
import static lotto.domain.model.Rank.FOURTH;
import static lotto.domain.model.Rank.SECOND;
import static lotto.domain.model.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankStatisticTest {

  @DisplayName("Test for various rank results")
  @Test
  public void testVariousRanks () {
    RankStatistic rankStatistic = new RankStatistic(
        Arrays.asList(
            THIRD,
            FOURTH,
            FIFTH, FIFTH,
            FAILURE, FAILURE, FAILURE, FAILURE, FAILURE, FAILURE
        )
    );

    assertThat(Double.compare(rankStatistic.calculateYield(), 156)).isEqualTo(0);

    assertThat(rankStatistic.countWinsOf(FIRST)).isEqualTo(0L);
    assertThat(rankStatistic.countWinsOf(SECOND)).isEqualTo(0L);
    assertThat(rankStatistic.countWinsOf(THIRD)).isEqualTo(1L);
    assertThat(rankStatistic.countWinsOf(FOURTH)).isEqualTo(1L);
    assertThat(rankStatistic.countWinsOf(FIFTH)).isEqualTo(2L);
    assertThat(rankStatistic.countWinsOf(FAILURE)).isEqualTo(6L);
  }
}
