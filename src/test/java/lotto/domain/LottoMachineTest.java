package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private static final LottoMachine lottoMachine = new LottoMachine();
    private static final int TICKET_AMOUNT = 1000;

    @Test
    @DisplayName("로또 발행 머신은 1장의 가격을 넣으면 1장이 발급된다.")
    void buyOneLottoTicket() {
        List<LottoTicket> tickets = lottoMachine.issue(TICKET_AMOUNT);
        assertThat(tickets).hasSize(1);
    }

    @Test
    @DisplayName("로또 발행 머신은 구입 금액에 해당하는 로또 티켓 N장을 발급해야 한다.")
    void buyLottoTickets() {
        int ticketCount = 5;
        List<LottoTicket> tickets = lottoMachine.issue(TICKET_AMOUNT * ticketCount);
        assertThat(tickets).hasSize(ticketCount);
    }

}