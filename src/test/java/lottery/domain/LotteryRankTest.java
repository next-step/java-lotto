package lottery.domain;

import org.junit.*;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    public void test_1등() {
        assertThat(LotteryRank.generate(6, false))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    public void test_2등() {
        assertThat(LotteryRank.generate(5, true))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    public void test_3등() {
        assertThat(LotteryRank.generate(5, false))
                .isEqualTo(LotteryRank.THIRD);
    }

    @Test
    public void test_4등() {
        assertThat(LotteryRank.generate(4, false))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    public void test_5등() {
        assertThat(LotteryRank.generate(3, false))
                .isEqualTo(LotteryRank.FIFTH);
    }

    @Test
    public void test_당첨없음() {
        assertThat(LotteryRank.generate(2, false))
                .isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.generate(2, true))
                .isEqualTo(LotteryRank.NONE);
    }

    @Test
    public void test_당첨금액() {
        assertThat(LotteryRank.values())
                .allMatch(rank -> rank.getWinningMoney(TicketCount.ONE).equals(rank.winningMoney));
    }
}
