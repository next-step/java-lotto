package lotto.model;

import lotto.LottoTicketMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    public void sellLottoTicket() {
        LottoTicketMaker lottoTicketMaker = new LottoTicketMaker();
        LottoTicket lottoTicket = lottoTicketMaker.issue();

        assertTrue(lottoTicket.getLotto().size() == 6);
    }

}