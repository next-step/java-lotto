package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void compare_tickets() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 12, 13, 14, 5, 6});

        assertThat(ticket6.matchWinner(winner)).isEqualTo(new LottoResult(ticket6, PrizeRank.of(6, false)));
        assertThat(ticket3.matchWinner(winner)).isEqualTo(new LottoResult(ticket3, PrizeRank.of(3, false)));
    }
}
