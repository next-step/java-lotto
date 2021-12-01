package lotto;

import lotto.domain.Tickets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    @Test
    void 구매_개수만큼_로또_반환() {
        Tickets tickets = new Tickets(6);
        Assertions.assertThat(tickets.getTickets().size()).isEqualTo(6);
    }
}
