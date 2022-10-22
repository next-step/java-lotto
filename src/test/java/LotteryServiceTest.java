import domain.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vo.LotteryTicket;
import vo.LotteryTickets;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryServiceTest {

    private LotteryService lotteryService;
    private List<LotteryTicket> firstPrizeLotteryTickets;
    private List<LotteryTicket> noPrizeLotteryTickets;
    private List<Integer> winnerTicket;

    @BeforeEach
    public void init() {
        lotteryService = new LotteryService();
        firstPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        noPrizeLotteryTickets = List.of(new LotteryTicket(Arrays.asList(11, 21, 31, 41, 15, 16)));
        winnerTicket = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 총복권개수조회() {
        long amount = 10000;
        long expected = 10;

        assertThat(lotteryService.countOfLotteryTickets(amount)).isEqualTo(expected);
    }

    @Test
    public void 복권번호생성() {
        List<LotteryTicket> lotteryTickets = lotteryService.generateLotteryTicketNumbers(1);

        for (int lotteryTicketNumber : lotteryTickets.get(0).getTicketNumbers()) {
            assertThat(lotteryTicketNumber).isBetween(1, 45);
        }
    }

    @Test
    public void 일등_당첨자수_1명() {
        assertThat(lotteryService.countOfLotteryWinners(6, firstPrizeLotteryTickets, winnerTicket)).isEqualTo(1);
    }

    @Test
    public void 꼴등_당첨자수_0명() {
        assertThat(lotteryService.countOfLotteryWinners(0, firstPrizeLotteryTickets, winnerTicket)).isEqualTo(0);
    }

    @Test
    public void 총수익구하기_1등() {
        assertThat(lotteryService.findTotalProfit(new LotteryTickets(firstPrizeLotteryTickets), new LotteryTicket(winnerTicket))).isEqualTo(2000000000);
    }

    @Test
    public void 총수익구하기_순위없음() {
        assertThat(lotteryService.findTotalProfit(new LotteryTickets(noPrizeLotteryTickets), new LotteryTicket(winnerTicket))).isEqualTo(0);
    }
}
