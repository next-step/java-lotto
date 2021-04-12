package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.AutoNumberGenerator;
import step2.utils.LottoNumberGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 장수 제대로 가져오는지 테스트")
    void getLottoTickets() {
        // given
        int expected = 6;
        LottoNumberGenerator lottoNumberGenerator = new AutoNumberGenerator();

        // when
        LottoTickets lotto = new LottoTickets(expected, lottoNumberGenerator);
        List<LottoTicket> lottoTickets = lotto.getLottoTickets();

        // then
        int actual = lottoTickets.size();
        assertEquals(expected, actual);
    }
}
