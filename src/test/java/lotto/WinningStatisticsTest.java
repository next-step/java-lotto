package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    @DisplayName("로또 결과를 등수별로 집계한다")
    void accumulateStatistics() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = List.of(
            new Lotto(1, 2, 3, 10, 11, 12),
            new Lotto(1, 2, 3, 4, 11, 12)
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(lottos, winning);

        assertThat(stats.countOf(Rank.FIFTH)).isEqualTo(1);
        assertThat(stats.countOf(Rank.FOURTH)).isEqualTo(1);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(0);
        assertThat(stats.countOf(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 당첨금은 등수별 상금의 합이다")
    void totalPrizeCalculation() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = List.of(
            new Lotto(1, 2, 3, 10, 11, 12),
            new Lotto(1, 2, 3, 4, 11, 12)
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(lottos, winning);

        assertThat(stats.totalPrize()).isEqualTo(55_000);
    }
}
