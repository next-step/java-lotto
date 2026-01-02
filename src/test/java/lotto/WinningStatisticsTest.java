package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    @DisplayName("당첨 결과를 등수별로 집계한다")
    void accumulateByRank() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7),  // 2등
            new Lotto(1, 2, 3, 4, 5, 10)  // 3등
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(tickets, winningNumbers);

        assertThat(stats.countOf(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨금은 등수별 상금 * 당첨횟수의 합이다")
    void totalPrize() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7),  // 30,000,000
            new Lotto(1, 2, 3, 4, 5, 10)  // 1,500,000
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(tickets, winningNumbers);

        assertThat(stats.totalPrize()).isEqualTo(31_500_000L);
    }
}
