package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    @DisplayName("총 당첨금은 등수별 상금 * 당첨횟수의 합이다")
    void totalPrize() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7),   // SECOND: 30,000,000
            new Lotto(1, 2, 3, 4, 5, 10)   // THIRD: 1,500,000
        );

        WinningStatistics stats = winningNumbers.match(tickets);

        assertThat(stats.totalPrize()).isEqualTo(31_500_000L);
    }

    @Test
    @DisplayName("수익률은 총 당첨금을 구입 금액으로 나눈 값이다")
    void profitRate() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> tickets = List.of(
            new Lotto(1, 2, 3, 4, 5, 7) // 30,000,000
        );

        WinningStatistics stats = winningNumbers.match(tickets);

        Money purchase = Money.of(10_000);
        assertThat(stats.profitRate(purchase)).isEqualTo(3000.0);
    }
}
