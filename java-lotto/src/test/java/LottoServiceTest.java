import domain.Lotto.LottoService;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void 로또_티켓_개수_확인() {
        List<LottoTicket> tickets = lottoService.generateLottoTickets(5);
        assertEquals(5, tickets.size());
    }

    @Test
    void 로또_당첨_결과_계산_확인() {
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 7, 8, 9)), // 3개
                new LottoTicket(List.of(1, 2, 3, 4, 8, 9)), // 4개
                new LottoTicket(List.of(1, 2, 3, 4, 5, 9)), // 5개
                new LottoTicket(List.of(10, 11, 12, 13, 14, 15)) // 0개
        );
        LottoTicket winning = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winning,10);
        var result = lottoService.calculateResults(tickets, winningLotto);

        assertEquals(1, result.getMatchCounts().get(3));
        assertEquals(1, result.getMatchCounts().get(4));
        assertEquals(1, result.getMatchCounts().get(5));
        assertNull(result.getMatchCounts().get(6));
    }
}