package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void compare_tickets() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket6 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket3 = new LottoTicket(new int[]{1, 12, 13, 14, 5, 6});
        int bonusNumber = 7;

        assertThat(ticket6.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket6, PrizeRank.of(6, false)));
        assertThat(ticket3.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket3, PrizeRank.of(3, false)));
    }

    @Test
    void compare_tickets_bonus() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket5 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 7});
        LottoTicket ticket4 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 8});
        int bonusNumber = 7;

        assertThat(ticket5.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket5, PrizeRank.of(5, true)));
        assertThat(ticket4.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket4, PrizeRank.of(5, false)));
    }
}
