package lottery.domain;

import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTicketTest {

    @Test
    public void test_당첨_1등() {
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        LotteryTicket myTicket = new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    public void test_당첨_2등() {
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        LotteryTicket myTicket = new LotteryTicket(Arrays.asList(2, 3, 4, 5, 6, 10));

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    public void test_당첨_3등() {
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        LotteryTicket myTicket = new LotteryTicket(Arrays.asList(2, 3, 4, 5, 6, 7));

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.THIRD);
    }

    @Test
    public void test_당첨_4등() {
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        LotteryTicket myTicket = new LotteryTicket(Arrays.asList(3, 4, 5, 6, 7, 8));

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    public void test_당첨_5등() {
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        LotteryTicket myTicket = new LotteryTicket(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FIFTH);
    }
}