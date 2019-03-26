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
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        List<LotteryTicket> tickets = createTickets(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6));

        LotteryRaffleMachine storage = new LotteryRaffleMachine(tickets);

        LotteryWinningStatistics statistics = storage.raffle(winningTicket);

        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(TicketCount.valueOf(2));
    }

    private List<LotteryTicket> createTickets(List<Integer> ...numbers) {
        return Arrays.asList(numbers)
                .stream()
                .map(LotteryTicket::new)
                .collect(Collectors.toList());
    }
}
