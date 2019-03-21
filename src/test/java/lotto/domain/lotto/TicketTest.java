package lotto.domain.lotto;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TicketTest {

    @Test
    public void 넘버_포함_여부() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);

        assertTrue(ticket.contains(new LottoNumber(3)));
    }

    @Test
    public void 넘버_포함_수_카운트() {
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        Ticket targetTicket = new Ticket(4, 5, 6, 7, 8, 9);

        assertThat(ticket.matchCount(targetTicket)).isEqualTo(3);
    }
}
