package lottery.machine;

import lottery.domain.*;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRaffleMachineTest {

    @Test
    public void test_추첨_1등_2개() {
        LotteryTicket firstRankNumbersTicket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");
        WinningTicket winningTicket = new WinningTicket(
                firstRankNumbersTicket, LotteryNumber.of(10));
        List<LotteryTicket> tickets = Arrays.asList(
                firstRankNumbersTicket, firstRankNumbersTicket);

        LotteryRaffleMachine storage = new LotteryRaffleMachine(tickets);

        LotteryWinningStatistics statistics = storage.raffle(winningTicket);

        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(TicketCount.valueOf(2));
    }
}
