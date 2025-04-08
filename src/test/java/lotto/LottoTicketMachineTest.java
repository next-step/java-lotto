package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoOrder;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("자동 구매 티켓 수만큼 자동 티켓을 구매한다.")
    void shouldPurchaseAutoTickets() {
        LottoOrder order1 = new LottoOrder(3000, 0);
        List<LottoTicket> tickets1 = LottoTicketMachine.purchase(order1);

        assertThat(tickets1).hasSize(3);
        for (LottoTicket ticket : tickets1) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }

        LottoOrder order2 = new LottoOrder(3000, 3);
        List<LottoTicket> tickets2 = LottoTicketMachine.purchase(order2);
        assertThat(tickets2).hasSize(0);
    }
}
