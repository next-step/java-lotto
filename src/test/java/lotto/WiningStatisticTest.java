package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WiningStatisticTest {

    @DisplayName(value = "당첨 갯수별로 반환한다.")
    @Test
    void 당첨_갯수별_통계() {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(ticket);
        List<Integer> lastWeeksWinningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);

        // when
        int purchaseNumber = 2;
        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber, () -> lottoTicket);
        WinningCounts winningCounts = new WinningCounts().calculateWinningCount(lottoTickets, lastWeeksWinningNumbers);

        // when
        WinningStatistic winningStatistic = new WinningStatistic(winningCounts);

        // then
        assertThat(winningStatistic.getStatistics(0)).isEqualTo(2);
        assertThat(winningStatistic.getStatistics(1)).isEqualTo(0);
        assertThat(winningStatistic.getStatistics(2)).isEqualTo(0);
        assertThat(winningStatistic.getStatistics(3)).isEqualTo(0);
    }
}