package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketMachineTest {

    @DisplayName("입력받은 금액만큼 로또 티켓 생성")
    @Test
    void issue() {
        //given
        int money = 2_001;
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

        //when
        LottoPack lottoPack = lottoTicketMachine.issueTickets(money);

        //then
        assertEquals(money / 1_000, lottoPack.ticketCount());
    }
}