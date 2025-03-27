package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.MatchCount;
import lotto.domain.PrizeRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void compare_tickets_bonus() {
        LottoTicket winner = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        LottoTicket ticket5 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 7});
        LottoTicket ticket4 = new LottoTicket(new int[]{1, 2, 3, 4, 5, 8});
        int bonusNumber = 7;

        assertThat(ticket5.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket5, PrizeRank.of(MatchCount.of(5), true)));
        assertThat(ticket4.matchWinner(winner, bonusNumber)).isEqualTo(new LottoResult(ticket4, PrizeRank.of(MatchCount.of(5), false)));
    }
}
