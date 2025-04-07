import domain.Lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 로또_번호_6개_생성되는지_확인() {
        LottoTicket ticket = new LottoTicket();
        assertEquals(6, ticket.getNumbers().size());
    }

    @Test
    void 로또_일치_개수_계산_확인() {
        LottoTicket ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        int matchCount = ticket.getMatchCount(List.of(1, 2, 3, 10, 11, 12));
        assertEquals(3, matchCount);
    }

    @Test
    void 번호가_6개_아닐_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(List.of(1, 2, 3)));
    }
}