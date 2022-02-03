package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.generator.AutoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    private static final int NUM_OF_TICKETS = 5;

    private Tickets tickets;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
        for (int index = 0; index < NUM_OF_TICKETS; index++) {
            Ticket ticket = new Ticket(new AutoGenerator().generateNumbers());
            tickets.addTicket(ticket);
        }
    }

    @DisplayName("생성한 로또 수만큼 개수 반환하는지 검증")
    @Test
    void testValidCountOfTickets() {
        assertThat(tickets.get().size())
            .isEqualTo(NUM_OF_TICKETS);
    }
}
