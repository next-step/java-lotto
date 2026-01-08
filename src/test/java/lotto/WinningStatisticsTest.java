package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    @DisplayName("총 당첨금은 등수별 상금 * 당첨횟수의 합이다")
    void totalPrize() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Lottos tickets = new Lottos(List.of(
            new Lotto(List.of(1,2,3,4,5,7)),   // SECOND
            new Lotto(List.of(1,2,3,4,5,10))   // THIRD
        ));

        WinningStatistics stats = winningNumbers.match(tickets);

        long expected = (long) Rank.SECOND.prize() + (long) Rank.THIRD.prize();
        assertThat(stats.totalPrize()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률(%)은 (총 당첨금 / 구입 금액) * 100 이다")
    void profitRate() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Lottos tickets = new Lottos(List.of(
            new Lotto(List.of(1,2,3,4,5,7)) // SECOND
        ));

        WinningStatistics stats = winningNumbers.match(tickets);

        Money purchase = Money.of(10_000);
        double expected = (double) Rank.SECOND.prize() * 100 / purchase.amount();

        assertThat(stats.profitRate(purchase)).isEqualTo(expected);
    }
}
