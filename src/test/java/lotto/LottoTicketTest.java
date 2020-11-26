package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @DisplayName(value = "")
    @Test
    void 로또_티켓_1개_생성() {
        // given
        LottoTicket lottoTicket = new LottoTicket();

        // when
        LottoTicket autoTicket = lottoTicket.createAuto();

        // then
        assertThat(autoTicket.size()).isEqualTo(6);
    }
}