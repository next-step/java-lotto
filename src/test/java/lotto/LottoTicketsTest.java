package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketsTest {
    @DisplayName("발급받은 로또번호들의 상금을 반환한다")
    @Test
    void prizes() {
        WinningTicket winningTicket = WinningTicket.of(List.of(1, 2, 3, 4, 5, 6), 45);

        LottoTicket allMatcheslottoTicket = LottoTicketFixture.of(1, 2, 3, 4, 5, 6);
        LottoTicket secondRankLottoTicket = LottoTicketFixture.of(1, 2, 3, 4, 5, 45);

        LottoTickets lottoTickets = new LottoTickets(List.of(allMatcheslottoTicket, secondRankLottoTicket));
        List<LottoPrize> winningPrizes = lottoTickets.calculatePrizes(winningTicket);

        assertEquals(List.of(LottoPrize.RANK1, LottoPrize.RANK2), winningPrizes);
    }
}
