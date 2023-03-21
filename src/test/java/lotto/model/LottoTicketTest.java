package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    public void sellLottoTicket() {
        LottoTicket lottoTicket = LottoTicket.issue();
        assertTrue(lottoTicket.getLotto().size() == 6);
    }
}