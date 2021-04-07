package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 장수 제대로 가져오는지 테스트")
    void getLottoTickets() {
        int expected = 6;

        LottoTickets lotto = new LottoTickets(expected);
        List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        int actual = lottoTickets.size();

        assertEquals(expected, actual);
    }
}
