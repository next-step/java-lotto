package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketMachineTest {

    private final TicketMachine ticketMachine = new TicketMachine();

    @Test
    @DisplayName("로또 티켓을 구매한다")
    void buyLottoTickets() {
        //given
        Money money = new Money(10000);

        //when
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(money);

        //then
        assertThat(lottoTickets).hasSize(10);
    }

}