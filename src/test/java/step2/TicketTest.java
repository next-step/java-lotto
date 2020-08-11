package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Ticket;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void matchCount() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        Ticket ticket = new Ticket(numbers);

        assertThat(ticket.matchCount(numbers)).isEqualTo(numbers.length);
    }
}