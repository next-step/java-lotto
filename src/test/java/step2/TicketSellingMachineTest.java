package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class TicketSellingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"900=0", "1000=1", "10000=10"}, delimiter = '=')
    void buy(int money, int ticketCount) {
        List<Ticket> tickets = TicketSellingMachine.buy(money);

        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6=1"}, delimiter = '=')
    void buy(String numbers, int ticketCount) {
        List<Ticket> tickets = TicketSellingMachine.buy(
                ticketCount,
                Arrays.asList(
                        Arrays.stream(numbers.split(","))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .collect(Collectors.toList()))

        );
        assertThat(tickets.size()).isEqualTo(ticketCount);
    }

    @Test
    void buy() {
        List<Ticket> tickets = TicketSellingMachine.buy(
                2,
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                )

        );
        assertThat(tickets.size()).isEqualTo(2);
    }

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


}