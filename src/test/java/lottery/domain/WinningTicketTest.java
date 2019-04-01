package lottery.domain;

import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTicketTest {

    final LotteryNumber bonusNumber = LotteryNumber.of(10);
    final WinningTicket winningTicket =
            new WinningTicket(LotteryTicket.generate("1, 2, 3, 4, 5, 6"), bonusNumber);

    @Test
    public void test_당첨_1등() {
        LotteryTicket myTicket = LotteryTicket.generate("1, 2, 3, 4, 5, 6");

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    public void test_당첨_2등() {
        LotteryTicket myTicket = LotteryTicket.generate("2, 3, 4, 5, 6, " + bonusNumber);

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    public void test_당첨_3등() {
        LotteryTicket myTicket = LotteryTicket.generate("2, 3, 4, 5, 6, 7");

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.THIRD);
    }

    @Test
    public void test_당첨_4등() {
        LotteryTicket myTicket = LotteryTicket.generate("3, 4, 5, 6, 7, 8");

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    public void test_당첨_5등() {
        LotteryTicket myTicket = LotteryTicket.generate("4, 5, 6, 7, 8, 9");

        assertThat(winningTicket.raffle(myTicket))
                .isEqualTo(LotteryRank.FIFTH);
    }
}