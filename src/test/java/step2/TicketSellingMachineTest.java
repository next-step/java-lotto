package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketSellingMachineTest {

    @Test
    void ticketing() {
        Ticket ticket = TicketSellingMachine.ticketing();

        assertThat(ticket).isNotNull();
    }

    @Test
    void forceTicketing() {
        Ticket ticket = TicketSellingMachine.ticketing(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket).isEqualTo(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"900=0", "1000=1", "10000=10"}, delimiter = '=')
    void buy(int money, int ticketCount) {
        List<Ticket> tickets = TicketSellingMachine.buy(money);

        assertThat(tickets.size()).isEqualTo(ticketCount);
    }
}