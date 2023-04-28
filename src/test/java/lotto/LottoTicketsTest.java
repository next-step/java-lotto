package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketsTest {
    @DisplayName("발급받은 로또번호들 중 일치여부를 판단해 일치하는 개수를 판단한다")
    @Test
    void matchesLottoTickets() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket allMatcheslottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket secondRankLottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 45));

        LottoTickets lottoTickets = new LottoTickets(List.of(allMatcheslottoTicket, secondRankLottoTicket));
        List<Integer> matchesCounts = lottoTickets.matchesLottoTicketCount(winningNumbers);

        assertEquals(List.of(6, 5), matchesCounts);
    }
}
