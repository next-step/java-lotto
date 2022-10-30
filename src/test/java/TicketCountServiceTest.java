import domain.ticket.TicketCountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketCountServiceTest {
    private TicketCountService ticketCountService;

    @BeforeEach
    public void init() {
        ticketCountService = new TicketCountService();
    }

    @Test
    @Order(1)
    public void 총복권개수조회_10개() {
        long amount = 10000;
        long expected = 10;

        assertThat(ticketCountService.countOfLotteryTickets(amount)).isEqualTo(expected);
    }

    @Test
    @Order(2)
    public void 총복권개수조회_0개() {
        long amount = 0;
        long expected = 0;

        assertThat(ticketCountService.countOfLotteryTickets(amount)).isEqualTo(expected);
    }
}
