package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoOrder;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("주문대로 티켓을 구매한다.")
    void shouldPurchaseManualTickets() {
        LottoOrder lottoOrder = new LottoOrder(5000, List.of(List.of(1, 2, 3, 4, 5, 6)));
        LottoTickets tickets = LottoTicketMachine.purchase(lottoOrder);

        assertThat(tickets.getTickets()).hasSize(5);
    }
}
