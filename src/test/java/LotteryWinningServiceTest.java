import domain.lottery.LotteryWinningService;
import domain.ticket.TicketCountService;
import domain.ticket.TicketNumberService;
import dto.lottery.LotteryTicket;
import dto.lottery.LotteryTickets;
import dto.lottery.WinnerLotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWinningServiceTest {

    private LotteryWinningService lotteryWinningService;
    private TicketNumberService ticketNumberService;
    private TicketCountService ticketCountService;
    private List<LotteryTicket> firstPrizeLotteryTickets;
    private List<LotteryTicket> secondPrizeLotteryTickets;
    private List<LotteryTicket> secondPrizeWithBonusNumberLotteryTickets;
    private List<LotteryTicket> noPrizeLotteryTickets;
    private WinnerLotteryTicket winnerTicket;

    @BeforeEach
    public void init() {
        lotteryWinningService = new LotteryWinningService();
        ticketNumberService = new TicketNumberService();
        ticketCountService = new TicketCountService();

        firstPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        secondPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(2,3,4,6,1,10)));
        secondPrizeWithBonusNumberLotteryTickets = List.of(new LotteryTicket(Arrays.asList(2,3,4,6,5,7)));
        noPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(11, 21, 31, 41, 15, 16)));
        LotteryTicket winnerTicketNumbers = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        winnerTicket = new WinnerLotteryTicket(winnerTicketNumbers, 7);
    }


    @Test
    @Order(1)
    public void 로또_1등_당첨자수_1명() {
        assertThat(lotteryWinningService.countOfLotteryWinners(6, firstPrizeLotteryTickets, winnerTicket, ticketNumberService)).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void 로또_2등_보너스번호_당첨자수_1명() {
        assertThat(lotteryWinningService.countOfLotteryWinners(5, secondPrizeWithBonusNumberLotteryTickets, winnerTicket, ticketNumberService)).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void 로또_꼴등_당첨자수_1명() {
        assertThat(lotteryWinningService.countOfLotteryWinners(0, noPrizeLotteryTickets, winnerTicket, ticketNumberService)).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void 총수익구하기_1등() {
        assertThat(lotteryWinningService.findTotalRewards(new LotteryTickets(firstPrizeLotteryTickets), winnerTicket, ticketNumberService)).isEqualTo(2000000000);
    }

    @Test
    @Order(5)
    public void 총수익구하기_2등() {
        assertThat(lotteryWinningService.findTotalRewards(new LotteryTickets(secondPrizeLotteryTickets), winnerTicket, ticketNumberService)).isEqualTo(1500000);
    }

    @Test
    @Order(6)
    public void 총수익구하기_2등_보너스번호() {
        assertThat(lotteryWinningService.findTotalRewards(new LotteryTickets(secondPrizeWithBonusNumberLotteryTickets), winnerTicket, ticketNumberService)).isEqualTo(30000000);
    }

    @Test
    @Order(7)
    public void 총수익구하기_순위없음() {
        assertThat(lotteryWinningService.findTotalRewards(new LotteryTickets(noPrizeLotteryTickets), winnerTicket, ticketNumberService)).isEqualTo(0);
    }
}
