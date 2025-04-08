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
    @DisplayName("유효한 구매 금액으로 티켓을 구매할 수 있다")
    void shouldPurchaseTickets() {
        LottoOrder price = new LottoOrder("3000");
        List<LottoTicket> tickets = LottoTicketMachine.purchase(price);

        assertThat(tickets).hasSize(3);
        for (LottoTicket ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
        }
    }
}
