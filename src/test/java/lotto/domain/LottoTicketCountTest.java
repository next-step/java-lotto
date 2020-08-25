package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketCountTest {

    @Test
    @DisplayName("구매한 자동/수동 로또 티켓 갯수 확인")
    void lotto_ticket_count_test() {
        LottoTicketCount lottoTicketCount = new LottoTicketCount.LottoTicketCountBuilder()
                .money(10000)
                .manualLottoCount(4)
                .build();
        assertEquals(6, lottoTicketCount.getAutoLottoTicketCount());
        assertEquals(4, lottoTicketCount.getManualLottoTicketCount());
    }

}