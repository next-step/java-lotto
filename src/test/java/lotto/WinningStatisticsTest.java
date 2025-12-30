package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    @DisplayName("로또 결과를 등수별로 집계한다")
    void accumulateStatistics() {
        WinningNumbers winning = new WinningNumbers(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1,2,3,10,11,12)),
            new Lotto(List.of(1,2,3,4,11,12))
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(lottos, winning);

        assertThat(stats.countOf(Rank.THREE)).isEqualTo(1);
        assertThat(stats.countOf(Rank.FOUR)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨금은 등수별 상금의 합이다")
    void totalPrizeCalculation() {
        WinningNumbers winning = new WinningNumbers(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1,2,3,10,11,12))
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(lottos, winning);

        assertThat(stats.totalPrize()).isEqualTo(5_000);
    }

    @Test
    @DisplayName("수익률은 총 당첨금을 구입 금액으로 나눈 값이다")
    void profitRateCalculation() {
        WinningStatistics stats = new WinningStatistics();
        Money purchase = Money.of(1000);

        assertThat(stats.profitRate(purchase)).isEqualTo(0.0);
    }
}
