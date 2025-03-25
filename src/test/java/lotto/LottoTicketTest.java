package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void compare_tickets() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket2 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 12, 13, 14, 5, 6});

        assertThat(ticket2.matchWinner(winner)).isEqualTo(new LottoResult(ticket2, MatchCount.of(6)));
        assertThat(ticket3.matchWinner(winner)).isEqualTo(new LottoResult(ticket3, MatchCount.of(3)));
    }
}
