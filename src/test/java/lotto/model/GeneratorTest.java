package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {
    @Test
    @DisplayName("AutomaticTicketGenerator는 티켓을 자동 방식으로 생성한다.")
    void generate_AutomaticTicket() {
        TicketGenerator ticketGenerator = new AutomaticTicketGenerator();
        Ticket ticket = ticketGenerator.generate();

        assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("ManualTicketGenerator는 티켓을 수동 방식으로 생성한다.")
    void generate_ManualTicket() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        TicketGenerator ticketGenerator = new ManualTicketGenerator(numbers);
        Ticket ticket = ticketGenerator.generate();

        assertThat(ticket).isInstanceOf(Ticket.class);
    }
}
