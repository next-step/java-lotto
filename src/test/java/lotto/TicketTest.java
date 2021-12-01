package lotto;

import lotto.domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {

    @Test
    void 티켓_길이_검사() {
        Ticket ticket = new Ticket();
        Assertions.assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }
}
