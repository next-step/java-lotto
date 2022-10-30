import domain.LotteryWinningService;
import domain.TicketCountService;
import domain.TicketNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import vo.LotteryTicket;
import vo.LotteryTickets;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWinningServiceTest {

    private LotteryWinningService lotteryWinningService;
    private TicketNumberService ticketNumberService;
    private TicketCountService ticketCountService;
    private List<LotteryTicket> firstPrizeLotteryTickets;
    private List<LotteryTicket> noPrizeLotteryTickets;
    private List<Integer> winnerTicket;

    @BeforeEach
    public void init() {
        lotteryWinningService = new LotteryWinningService();
        ticketNumberService = new TicketNumberService();
        ticketCountService = new TicketCountService();

        firstPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        noPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(11, 21, 31, 41, 15, 16)));
        winnerTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
    }


    @Test
    @Order(1)
    public void 일등_당첨자수_1명() {
        assertThat(lotteryWinningService.countOfLotteryWinners(6, firstPrizeLotteryTickets, winnerTicket, ticketNumberService)).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void 꼴등_당첨자수_1명() {
        assertThat(lotteryWinningService.countOfLotteryWinners(0, noPrizeLotteryTickets, winnerTicket, ticketNumberService)).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void 총수익구하기_1등() {
        assertThat(lotteryWinningService.findTotalProfit(new LotteryTickets(firstPrizeLotteryTickets), new LotteryTicket(winnerTicket), ticketNumberService)).isEqualTo(2000000000);
    }

    @Test
    @Order(4)
    public void 총수익구하기_순위없음() {
        assertThat(lotteryWinningService.findTotalProfit(new LotteryTickets(noPrizeLotteryTickets), new LotteryTicket(winnerTicket), ticketNumberService)).isEqualTo(0);
    }
}
