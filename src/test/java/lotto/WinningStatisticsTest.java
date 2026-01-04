package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    @DisplayName("WinningStatistics는 Rank를 누적해 등수별 당첨 횟수를 계산한다")
    void accumulateCounts() {
        WinningStatistics stats = new WinningStatistics();

        stats.accumulate(Rank.SECOND);
        stats.accumulate(Rank.SECOND);
        stats.accumulate(Rank.THIRD);

        assertThat(stats.countOf(Rank.SECOND)).isEqualTo(2);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(1);
        assertThat(stats.countOf(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 당첨금은 등수별 상금 * 당첨횟수의 합이다")
    void totalPrize() {
        WinningStatistics stats = new WinningStatistics();

        stats.accumulate(Rank.SECOND);
        stats.accumulate(Rank.THIRD);
        stats.accumulate(Rank.THIRD);

        long expected = (long) Rank.SECOND.prize()
            + (long) Rank.THIRD.prize() * 2;

        assertThat(stats.totalPrize()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률은 총 당첨금 / 구입 금액이다")
    void profitRate() {
        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(Rank.SECOND);

        Money purchase = Money.of(10_000);
        double expected = (double) Rank.SECOND.prize() / purchase.amount();

        assertThat(stats.profitRate(purchase)).isEqualTo(expected);
    }

    @Test
    @DisplayName("아무것도 누적하지 않으면 총 당첨금은 0이다")
    void totalPrizeIsZeroWhenEmpty() {
        WinningStatistics stats = new WinningStatistics();

        assertThat(stats.totalPrize()).isEqualTo(0L);
    }
}
