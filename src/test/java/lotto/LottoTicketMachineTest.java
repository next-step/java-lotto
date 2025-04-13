package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoOrder;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("구매 티켓 수만큼 티켓을 구매한다.")
    void shouldPurchaseAutoTickets() {
        LottoOrder order = new LottoOrder(3000, 0);
        LottoTickets tickets = LottoTicketMachine.purchase(order);

        assertThat(tickets.getTickets()).hasSize(3);
    }
}
