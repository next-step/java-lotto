import domain.lottery.LotteryTicket;
import domain.lottery.LotteryTickets;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketsTest {

    @Test
    @Order(1)
    public void 복권번호생성_1개() {
        LotteryTickets lotteryTickets = new LotteryTickets(1000L);

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            assertThat(lotteryTicket.getTicketNumbers().stream().filter(number -> number >= 1 && number <= 45)).hasSize(lotteryTicket.getTicketNumbers().size());
        }
    }

    @Test
    @Order(2)
    public void 복권번호생성_10개() {
        LotteryTickets lotteryTickets = new LotteryTickets(10000L);

        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
            assertThat(lotteryTicket.getTicketNumbers().stream().filter(number -> number >= 1 && number <= 45)).hasSize(lotteryTicket.getTicketNumbers().size());
        }
    }
}
