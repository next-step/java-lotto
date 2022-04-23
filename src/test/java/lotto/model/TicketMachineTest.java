package lotto.model;

import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Money;
import lotto.model.lotto.TicketMachine;
import lotto.model.lotto.strategy.NumberGenerationStrategy;
import lotto.model.lotto.strategy.RandomGenerationStrategy;
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
         NumberGenerationStrategy numberGenerationStrategy = new RandomGenerationStrategy();
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(money, numberGenerationStrategy);

        //then
        assertThat(lottoTickets).hasSize(10);
    }

}