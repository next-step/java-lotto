import domain.lottery.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RewardLotteryTicketTest {

    private RewardLotteryTickets rewardLotteryTickets;

    @BeforeEach
    public void init() {
        LotteryTickets lotteryTickets = new LotteryTickets(List.of(
                LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))),
                LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(6), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(10))),
                LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                        LotteryNumber.of(11), LotteryNumber.of(5), LotteryNumber.of(6))),
                LotteryTicket.of(Arrays.asList(
                        LotteryNumber.of(11), LotteryNumber.of(12), LotteryNumber.of(13),
                        LotteryNumber.of(14), LotteryNumber.of(15), LotteryNumber.of(17)))
        ));
        WinnerLotteryTicket winnerLotteryTicket = new WinnerLotteryTicket(LotteryTicket.of(Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6))), LotteryNumber.of(10));
        rewardLotteryTickets = new RewardLotteryTickets(lotteryTickets, winnerLotteryTicket);
    }

    @Test
    @Order(0)
    public void 모든로또티켓_등수확인() {
        assertAll(
                () -> assertThat(rewardLotteryTickets.countOfRank(6)).isEqualTo(1),
                () -> assertThat(rewardLotteryTickets.countOfRank(5)).isEqualTo(1),
                () -> assertThat(rewardLotteryTickets.countOfRank(7)).isEqualTo(1),
                () -> assertThat(rewardLotteryTickets.countOfRank(0)).isEqualTo(1)
        );
    }

    @Test
    @Order(1)
    public void 모든로또티켓_당첨금액확인() {
        assertThat(rewardLotteryTickets.sumAllRewards()).isEqualTo(2031500000L);
    }
}
