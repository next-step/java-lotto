package lottery.domain;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWinningStatisticsTest {

    @Test
    public void test_티켓_10개_당첨_없음() {
        LotteryTicket winningTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LotteryTicket> myTickets = createTickets(Arrays.asList(), 10, Arrays.asList(7, 8, 9, 10, 11, 12));

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);
        assertThat(statistics.countRank(LotteryRank.NONE))
                .isEqualTo(10);

        assertThat(statistics.revenueRate())
                .isEqualTo(0.00);
    }

    @Test
    public void test_티켓_10개중_1등_1개() {
        LotteryTicket winningTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LotteryTicket> myTickets = createTickets(Arrays.asList(winningTicket),
                9, Arrays.asList(7, 8, 9, 10, 11, 12));

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.FIRST))
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE))
                .isEqualTo(9);

        assertThat(statistics.revenueRate())
                .isEqualTo(200_000.00);
    }

    @Test
    public void test_티켓_10개중_2등_1개() {
        LotteryTicket winningTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LotteryTicket secondRankTicket = new LotteryTicket(Arrays.asList(2, 3, 4, 5, 6, 7));
        List<LotteryTicket> myTickets = createTickets(Arrays.asList(secondRankTicket),
                9, Arrays.asList(7, 8, 9, 10, 11, 12));

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.SECOND))
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE))
                .isEqualTo(9);

        assertThat(statistics.revenueRate())
                .isEqualTo(150.00);
    }

    @Test
    public void test_티켓_10개중_3등_1개() {
        LotteryTicket winningTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LotteryTicket thirdRankTicket = new LotteryTicket(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<LotteryTicket> myTickets = createTickets(Arrays.asList(thirdRankTicket),
                9, Arrays.asList(7, 8, 9, 10, 11, 12));

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.THIRD))
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE))
                .isEqualTo(9);

        assertThat(statistics.revenueRate())
                .isEqualTo(5.00);
    }

    @Test
    public void test_티켓_10개중_4등_1개() {
        LotteryTicket winningTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LotteryTicket fourthRankTicket = new LotteryTicket(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<LotteryTicket> myTickets = createTickets(Arrays.asList(fourthRankTicket),
                9, Arrays.asList(7, 8, 9, 10, 11, 12));

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.FOURTH))
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE))
                .isEqualTo(9);

        assertThat(statistics.revenueRate())
                .isEqualTo(0.50);
    }

    private List<LotteryTicket> createTickets(List<LotteryTicket> winningTickets, int losingTicketSize, List<Integer> losingNumbers) {
        final List<LotteryTicket> result = IntStream.range(0, losingTicketSize)
                .mapToObj(i -> new LotteryTicket(losingNumbers))
                .collect(Collectors.toList());
        result.addAll(winningTickets);
        return result;
    }
}
