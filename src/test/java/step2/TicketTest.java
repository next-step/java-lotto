package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Model.Ticket;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {
    @Test
    @DisplayName("입력된 금액만큼 로또가 구입되는지 확인")
    void buyTicketsTest() {
        Ticket ticket = new Ticket(14000);
        assertThat(ticket.countGames()).isEqualTo(14);
    }
}
