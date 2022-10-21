package lotto.utils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {

    @Test
    void buyTickets() {
        assertThat(Ticket.getNumberOfTickets(BigDecimal.valueOf(10000))).isEqualTo(10);
    }
}