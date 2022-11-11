import domain.lottery.RewardLotteryTickets;
import service.LotteryService;
import domain.lottery.LotteryTicket;
import domain.lottery.LotteryTickets;
import domain.lottery.WinnerLotteryTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryServiceTest {

    private LotteryService lotteryService;
    private LotteryTickets firstPrizeLotteryTickets;
    private LotteryTickets secondPrizeLotteryTickets;
    private LotteryTickets secondPrizeWithBonusNumberLotteryTickets;
    private LotteryTickets noPrizeLotteryTickets;
    private WinnerLotteryTicket winnerTicket;

    @BeforeEach
    public void init() {
        lotteryService = new LotteryService();

        firstPrizeLotteryTickets = new LotteryTickets(List.of(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6))));
        secondPrizeLotteryTickets = new LotteryTickets(List.of(new LotteryTicket(Arrays.asList(2, 3, 4, 6, 1, 10))));
        secondPrizeWithBonusNumberLotteryTickets = new LotteryTickets(List.of(new LotteryTicket(Arrays.asList(2, 3, 4, 6, 5, 7))));
        noPrizeLotteryTickets = new LotteryTickets(List.of(new LotteryTicket(Arrays.asList(11, 21, 31, 41, 15, 16))));
        LotteryTicket winnerTicketNumbers = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));
        winnerTicket = new WinnerLotteryTicket(winnerTicketNumbers, 7);
    }

    @Test
    @Order(1)
    public void 로또_1등_당첨자수_1명() {
        assertThat(lotteryService.countOfLotteryWinners(6, new RewardLotteryTickets(firstPrizeLotteryTickets, winnerTicket))).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void 로또_2등_보너스번호_당첨자수_1명() {
        assertThat(lotteryService.countOfLotteryWinners(7, new RewardLotteryTickets(secondPrizeWithBonusNumberLotteryTickets, winnerTicket))).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void 로또_2등_당첨자수_1명() {
        assertThat(lotteryService.countOfLotteryWinners(5, new RewardLotteryTickets(secondPrizeLotteryTickets, winnerTicket))).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void 로또_꼴등_당첨자수_1명() {
        assertThat(lotteryService.countOfLotteryWinners(0, new RewardLotteryTickets(noPrizeLotteryTickets, winnerTicket))).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void 총수익구하기_1등() {
        assertThat(lotteryService.findTotalRewards(new RewardLotteryTickets(firstPrizeLotteryTickets, winnerTicket))).isEqualTo(2000000000);
    }

    @Test
    @Order(5)
    public void 총수익구하기_2등() {
        assertThat(lotteryService.findTotalRewards(new RewardLotteryTickets(secondPrizeLotteryTickets, winnerTicket))).isEqualTo(1500000);
    }

    @Test
    @Order(6)
    public void 총수익구하기_2등_보너스번호() {
        assertThat(lotteryService.findTotalRewards(new RewardLotteryTickets(secondPrizeWithBonusNumberLotteryTickets, winnerTicket))).isEqualTo(30000000);
    }

    @Test
    @Order(7)
    public void 총수익구하기_순위없음() {
        assertThat(lotteryService.findTotalRewards(new RewardLotteryTickets(noPrizeLotteryTickets, winnerTicket))).isEqualTo(0);
    }
}
