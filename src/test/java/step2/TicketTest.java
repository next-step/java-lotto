package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicketTest {

    LottoGame lottoGame = new LottoGame();

    @Test
    void 숫자_6개() {
        List<Ticket> tickets = lottoGame.makeTickets(7000);
        assertThat(tickets.get(0).getTicket()).hasSize(6);
    }

}
