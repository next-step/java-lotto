package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void compare_tickets() {
        LottoTicket ticket1 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket2 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 12, 13, 14, 5, 6});

        assertThat(ticket1.matchWinner(ticket2)).isEqualTo(new LottoResult(ticket1, new MatchCount(6)));
        assertThat(ticket1.matchWinner(ticket3)).isEqualTo(new LottoResult(ticket1, new MatchCount(3)));
    }
}
