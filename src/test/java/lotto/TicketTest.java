package lotto;

import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    void create() {
        Ticket ticket = Ticket.create();

        assertThat(ticket.getLottoNumbers()).hasSize(6);
    }
}
