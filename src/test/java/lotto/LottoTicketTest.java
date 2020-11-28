package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @DisplayName(value = "")
    @Test
    void 로또_티켓_1개_생성() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // when
        LottoTicket autoTicket = lottoTicket.newTicket();

        // then
        assertThat(autoTicket.size()).isEqualTo(6);
    }
}