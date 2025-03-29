package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SummaryReportTest {
    @Test
    void calculate() {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 5, 6}));
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 14, 15, 16}));
        LottoTicket winner = new LottoTicket(new int[]{4, 5, 6, 7, 8, 9});

        SummaryReport report = lottoTickets.getSummary(winner, 45);
        assertThat(report.getProfit()).isEqualTo(2.5f);
    }
}
