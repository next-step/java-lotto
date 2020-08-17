package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Receipt;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.TicketSellingMachine.TICKET_PRICE;

class TicketSellingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"900=0", "1000=1", "10000=10"}, delimiter = '=')
    void buy(int money, int ticketCount) {
        Receipt receipt = TicketSellingMachine.buy(money);

        assertThat(receipt.getTickets().size()).isEqualTo(ticketCount);
        assertThat(receipt.getChange()).isEqualTo(money % TICKET_PRICE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000=1,2,3,4,5,6=1"}, delimiter = '=')
    void buy(int money, String numbers, int ticketCount) {
        Receipt receipt = TicketSellingMachine.buy(
                money,
                Arrays.asList(
                        Arrays.stream(numbers.split(","))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .collect(Collectors.toList()))

        );
        assertThat(receipt.getTickets().size()).isEqualTo(ticketCount);
    }

    @Test
    void duplicateBuy() {
        Receipt receipt = TicketSellingMachine.buy(
                2000,
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                )
        );
        assertThat(receipt.getTickets().size()).isEqualTo(2);
    }

    @Test
    void ticketing() {
        Ticket ticket = TicketSellingMachine.ticketing();

        assertThat(ticket).isNotNull();
    }

    @Test
    void ticketingBySelf() {
        Ticket ticket = TicketSellingMachine.ticketing(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(ticket).isEqualTo(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }


}