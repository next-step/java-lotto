package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.FIFTH.getMatchingCount()).isEqualTo(3);
        assertThat(LotteryRank.FIRST.getMatchingCount()).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(LotteryRank.FIRST.getPrize()).isEqualTo(2000000000);
    }

    @Test
    void valueOf_일반() {
        assertThat(LotteryRank.valueOf(0, false)).isEqualTo(LotteryRank.NONE);
        assertThat(LotteryRank.valueOf(3, false)).isEqualTo(LotteryRank.FIFTH);
        assertThat(LotteryRank.valueOf(6, false)).isEqualTo(LotteryRank.FIRST);
    }

    @Test
    void valueOf_보너스_볼() {
        assertThat(LotteryRank.valueOf(5, true)).isEqualTo(LotteryRank.SECOND);
        assertThat(LotteryRank.valueOf(5, false)).isEqualTo(LotteryRank.THIRD);
    }

}
