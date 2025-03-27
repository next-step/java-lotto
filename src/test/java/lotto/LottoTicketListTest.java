package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketList;
import lotto.domain.PrizeRank;
import lotto.domain.SummaryReport;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketListTest {
    @Test
    void summary_results() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicketList lottoTickets = new LottoTicketList();
        lottoTickets.add(winner);
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 14, 15, 16}));

        SummaryReport report = lottoTickets.getSummary(winner, 45);

        assertThat(report.getTicketCount(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(report.getTicketCount(PrizeRank.FIFTH)).isEqualTo(1);
    }
}
