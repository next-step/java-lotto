package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    @DisplayName("당첨 로또 비교")
    void compare_tickets_bonus() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket5 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 7});
        LottoTicket ticket4 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 8});
        int bonusNumber = 7;

        assertThat(ticket5.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket5, PrizeRank.of(MatchCount.of(5), true)));
        assertThat(ticket4.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket4, PrizeRank.of(MatchCount.of(5), false)));
    }
}
