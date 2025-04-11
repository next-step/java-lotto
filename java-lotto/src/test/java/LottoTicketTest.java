import domain.Lotto.LottoNo;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 로또_번호_6개_생성되는지_확인() {
        LottoTicket ticket = new LottoTicket();
        assertEquals(6, ticket.getNumbers().size());
    }

    @Test
    void 로또_일치_개수_계산_확인() {
        // 당첨 번호
        List<LottoNo> winningNumbers = List.of(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());
        LottoNo bonus = new LottoNo(7);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(winningNumbers, true), bonus);

        // 테스트 티켓
        List<LottoNo> testNumbers = List.of(1, 2, 3, 10, 11, 12).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

        LottoTicket ticket = new LottoTicket(testNumbers, true);
        int matchCount = winningLotto.matchCountWith(ticket);

        assertEquals(3, matchCount);
    }

    @Test
    void 번호가_6개_아닐_경우_예외_발생() {
        List<LottoNo> invalidNumbers = List.of(1, 2, 3).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(invalidNumbers, true));
    }
}