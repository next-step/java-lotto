package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    @DisplayName("5개 일치 + 보너스 일치는 2등으로 집계된다")
    void accumulateSecondRank() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(winning, BonusNumber.of(7));

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7) // 5 + bonus => SECOND
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(tickets, winningNumbers);

        assertThat(stats.countOf(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 당첨금은 등수별 (상금 * 당첨횟수)의 합이다")
    void totalPrizeIsSumOfPrizeTimesCount() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(winning, BonusNumber.of(7));

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7), // SECOND: 30,000,000
            new Lotto(1, 2, 3, 4, 5, 10) // THIRD: 1,500,000
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(tickets, winningNumbers);

        assertThat(stats.totalPrize()).isEqualTo(31_500_000L);
    }

    @Test
    @DisplayName("수익률은 총 당첨금을 구입 금액으로 나눈 값이다")
    void profitRateIsTotalPrizeDividedByPurchaseAmount() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(winning, BonusNumber.of(7));

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7) // 30,000,000
        );

        WinningStatistics stats = new WinningStatistics();
        stats.accumulate(tickets, winningNumbers);

        Money purchase = Money.of(10_000);
        assertThat(stats.profitRate(purchase)).isEqualTo(3000.0);
    }
}
