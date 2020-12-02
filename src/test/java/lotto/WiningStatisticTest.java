package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WiningStatisticTest {

    @DisplayName(value = "당첨 갯수별로 반환한다.")
    @Test
    void 당첨_갯수별_통계() {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = LottoTicket.newTicket(ticket);
        List<Integer> lastWeeksWinningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        int purchaseAmount = 10000;

        // when
        int purchaseNumber = 2;
        LottoTicketCreatable lottoTicketCreatable = new LottoTicketCreatable() {
            @Override
            public LottoTicket createTicket() {
                return lottoTicket;
            }

            @Override
            public LottoTickets createTickets(int purchaseNumber) {
                List<LottoTicket> ticketList = new ArrayList<>();
                for (int i = 0; i < purchaseNumber; i++) {
                    ticketList.add(createTicket());
                }

                return LottoTickets.newTickets(ticketList);
            }
        };
        LottoTickets lottoTickets = lottoTicketCreatable.createTickets(purchaseNumber);
        WinningCounts winningCounts = new WinningCounts().calculateWinningCount(lottoTickets, lastWeeksWinningNumbers);

        // when
        WinningStatistic winningStatistic = new WinningStatistic(winningCounts, purchaseAmount);

        // then
        assertThat(winningStatistic.getStatisticsCount(0)).isEqualTo(2);
        assertThat(winningStatistic.getStatisticsCount(1)).isEqualTo(0);
        assertThat(winningStatistic.getStatisticsCount(2)).isEqualTo(0);
        assertThat(winningStatistic.getStatisticsCount(3)).isEqualTo(0);
    }
}