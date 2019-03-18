package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    public void test_1등() {
        assertThat(LotteryRank.generate(6))
                .isEqualTo(LotteryRank.FIRST);
    }

    @Test
    public void test_2등() {
        assertThat(LotteryRank.generate(5))
                .isEqualTo(LotteryRank.SECOND);
    }

    @Test
    public void test_3등() {
        assertThat(LotteryRank.generate(4))
                .isEqualTo(LotteryRank.THIRD);
    }

    @Test
    public void test_4등() {
        assertThat(LotteryRank.generate(3))
                .isEqualTo(LotteryRank.FOURTH);
    }

    @Test
    public void test_당첨없음() {
        assertThat(LotteryRank.generate(0))
            .isEqualTo(LotteryRank.NONE);
    }
}
