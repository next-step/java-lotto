package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void constructor() {
        Ticket ticket = new Ticket();

        assertThat(ticket.getNumbers().length).isEqualTo(6);
    }
}