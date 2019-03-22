package lottery.domain;

import org.junit.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketTest {

    @Test
    public void test_티켓_생성() {
        createTicket(1, 2, 3, 4, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_적음() {
        createTicket(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_티켓_생성_불가능_개수가_많음() {
        createTicket(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void test_당첨_1등() {
        final LotteryTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);
        LotteryTicket myTicket = createTicket(1, 2, 3, 4, 5, 6);

        assertThat(myTicket.getWinningRank(winningTicket))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    public void test_당첨_2등() {
        final LotteryTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);
        LotteryTicket myTicket = createTicket(2, 3, 4, 5, 6, 7);

        assertThat(myTicket.getWinningRank(winningTicket))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    public void test_당첨_3등() {
        final LotteryTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);
        LotteryTicket myTicket = createTicket(3, 4, 5, 6, 7, 8);

        assertThat(myTicket.getWinningRank(winningTicket))
                .isEqualTo(LotteryRank.THIRD);
    }

    @Test
    public void test_당첨_4등() {
        final LotteryTicket winningTicket = createTicket(1, 2, 3, 4, 5, 6);
        LotteryTicket myTicket = createTicket(4, 5, 6, 7, 8, 9);

        assertThat(myTicket.getWinningRank(winningTicket))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    public void test_toString() {
        final LotteryTicket ticket = createTicket(1, 2, 3, 4, 5, 6);

        assertThat(ticket)
                .hasToString("[1, 2, 3, 4, 5, 6]");
    }

    private LotteryTicket createTicket(int... numbers) {
        return new LotteryTicket(IntStream.of(numbers)
                .boxed()
                .collect(Collectors.toList()));
    }
}