package lottery.domain;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryWinningStatisticsTest {

    final LotteryNumber bonusNumber = LotteryNumber.of(10);
    final WinningTicket winningTicket =
            new WinningTicket(LotteryTicket.generate("1, 2, 3, 4, 5, 6"), bonusNumber);

    final LotteryTicket losingTicket = LotteryTicket.generate("11, 12, 13, 14, 15, 16");

    @Test
    public void test_티켓_10개_당첨_없음() {
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(), 10);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(10);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(0.00);
    }

    @Test
    public void test_티켓_10개중_1등_1개() {
        LotteryTicket firstRankTicket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(firstRankTicket), 9);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.FIRST).getAmount())
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(9);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(200_000.00);
    }

    @Test
    public void test_티켓_10개중_2등_1개() {
        LotteryTicket secondRankTicket = LotteryTicket.generate("2, 3, 4, 5, 6, 10");
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(secondRankTicket), 9);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.SECOND).getAmount())
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(9);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(3_000.0);
    }

    @Test
    public void test_티켓_10개중_3등_1개() {
        LotteryTicket thirdRankTicket = LotteryTicket.generate("2, 3, 4, 5, 6, 7");
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(thirdRankTicket), 9);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.THIRD).getAmount())
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(9);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(150.00);
    }

    @Test
    public void test_티켓_10개중_4등_1개() {
        LotteryTicket fourthRankTicket = LotteryTicket.generate("3, 4, 5, 6, 7, 8");
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(fourthRankTicket), 9);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.FOURTH).getAmount())
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(9);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(5.00);
    }

    @Test
    public void test_티켓_10개중_5등_1개() {
        LotteryTicket fifthRankTicket = LotteryTicket.generate("4, 5, 6, 7, 8, 9");
        List<LotteryTicket> myTickets = createTicketsWithLosingTickets(
                Arrays.asList(fifthRankTicket), 9);

        LotteryWinningStatistics statistics = new LotteryWinningStatistics(winningTicket, myTickets);

        assertThat(statistics.countRank(LotteryRank.FIFTH).getAmount())
                .isEqualTo(1);
        assertThat(statistics.countRank(LotteryRank.NONE).getAmount())
                .isEqualTo(9);

        assertThat(statistics.revenueRate().getRate())
                .isEqualTo(0.50);
    }

    private List<LotteryTicket> createTicketsWithLosingTickets(List<LotteryTicket> designatedNumbersTicket, int losingTicketSize) {
        final List<LotteryTicket> result = IntStream.range(0, losingTicketSize)
                .mapToObj(i -> losingTicket)
                .collect(Collectors.toList());

        result.addAll(designatedNumbersTicket);
        return result;
    }
}
