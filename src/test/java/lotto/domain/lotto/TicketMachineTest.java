package lotto.domain.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TicketMachineTest {

    @Test
    public void 티켓_여러장_발급() {
        List<String> numbers = Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6", "2,3,4,5,6,7");
        List<Ticket> tickets = TicketMachine.generateTickets(numbers, ",");

        assertThat(tickets.size()).isEqualTo(3);
        assertTrue(tickets.get(0).contains(new LottoNumber(1)));
    }

    @Test
    public void 티켓_한장_발급() {
        String number = "1, 2, 3, 4, 5, 6";
        Ticket ticket = TicketMachine.generateTicket(number, ",");

        assertTrue(ticket.contains(new LottoNumber(2)));
    }
}
