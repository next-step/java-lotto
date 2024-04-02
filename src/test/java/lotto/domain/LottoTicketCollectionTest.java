package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketCollectionTest {


    @Test
    public void 로또_모음() {
        List<LottoTicket> autoTickets = List.of(
            LottoTicket.createTicket(List.of(1, 2, 3, 4, 5, 6)));
        List<LottoTicket> manualTickets = List.of();
        LottoTicketCollection ticketCollection = new LottoTicketCollection(autoTickets,
            manualTickets);

        assertThat(ticketCollection.getAutoTickets().size()).isEqualTo(1);
        assertThat(ticketCollection.getManualTickets().size()).isEqualTo(0);
    }
}
