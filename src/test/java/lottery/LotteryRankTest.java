package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.getMatchingCount(LotteryRank.FOURTH)).isEqualTo(3);
        assertThat(LotteryRank.getMatchingCount(LotteryRank.FIRST)).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.getPrize(LotteryRank.FOURTH)).isEqualTo(5000);
        assertThat(LotteryRank.getPrize(LotteryRank.FIRST)).isEqualTo(2000000000);
    }

    @Test
    void getUsedRanks() {
        assertThat(LotteryRank.getUsedMatchingCounts()).containsOnly(0, 3, 4, 5, 6);
    }

    @Test
    void getPrizeOfMatchingCount() {
        assertThat(LotteryRank.getPrizeOfMatchingCount(3)).isEqualTo(LotteryRank.getPrize(LotteryRank.FOURTH));
        assertThat(LotteryRank.getPrizeOfMatchingCount(6)).isEqualTo(LotteryRank.getPrize(LotteryRank.FIRST));
    }

    @Test
    void valueOf() {
        assertThat(LotteryRank.valueOf(3)).isEqualTo(LotteryRank.FOURTH);
        assertThat(LotteryRank.valueOf(6)).isEqualTo(LotteryRank.FIRST);
    }

}
