package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachine2Test {

    @DisplayName("입력한 숫자만큼 로또 티켓 발행")
    @Test
    void issueTicket() {
        int ticketCount = 3;
        LottoMachine2 lottoMachine2 = new LottoMachine2(ticketCount);

        //when
        List<LottoTicket2> lottoTicket2s = lottoMachine2.issueTickets();

        //then
        assertEquals(ticketCount, lottoTicket2s.size());
    }
}