import domain.lottery.LotteryNumber;
import domain.lottery.LotteryTicket;
import domain.lottery.LotteryTickets;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketsTest {

    @Test
    @Order(1)
    public void 복권번호생성_1개() {
        LotteryTickets lotteryTickets = new LotteryTickets(1000L);
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(1);
    }

    @Test
    @Order(2)
    public void 복권번호생성_10개() {
        LotteryTickets lotteryTickets = new LotteryTickets(10000L);
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(10);
    }

    @Test
    @Order(3)
    public void 복권번호생성_수동2_자동12() {
        LotteryTickets lotteryTickets = new LotteryTickets(12);
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(12);

        lotteryTickets.add(LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(7))));
        lotteryTickets.add(LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(10))));
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(14);
    }
}
