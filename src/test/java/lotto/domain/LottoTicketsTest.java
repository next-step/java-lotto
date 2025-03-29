package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @Test
    void generate() {
        int money = 14000;
        LottoTickets lottoTickets = LottoTickets.generate(money);
        int expectedCount = money / LottoTicket.PRICE;
        assertThat(lottoTickets.size()).isEqualTo(expectedCount);
    }

    @Test
    void summary_results() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(winner);
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 14, 15, 16}));

        SummaryReport report = lottoTickets.getSummary(winner, 45);

        assertThat(report.getTicketCount(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(report.getTicketCount(PrizeRank.FIFTH)).isEqualTo(1);
    }
}
