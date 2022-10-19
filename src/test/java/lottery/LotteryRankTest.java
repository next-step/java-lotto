package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.getMatchingCount(LotteryRank.THREE)).isEqualTo(3);
        assertThat(LotteryRank.getMatchingCount(LotteryRank.SIX)).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.getPrize(LotteryRank.THREE)).isEqualTo(5000);
        assertThat(LotteryRank.getPrize(LotteryRank.SIX)).isEqualTo(2000000000);
    }

    @Test
    void getUsedRanks() {
        assertThat(LotteryRank.getUsedMatchingCounts()).containsExactly(3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:true", "6:true", "7:false"}, delimiter = ':')
    void isUsedMatchingCount(int matchingCount, boolean expected) {
        assertThat(LotteryRank.isUsedMatchingCount(matchingCount)).isEqualTo(expected);
    }

    @Test
    void getPrizeOfMatchingCount() {
        assertThat(LotteryRank.getPrizeOfMatchingCount(3)).isEqualTo(LotteryRank.getPrize(LotteryRank.THREE));
        assertThat(LotteryRank.getPrizeOfMatchingCount(6)).isEqualTo(LotteryRank.getPrize(LotteryRank.SIX));
    }

    @Test
    void valueOf() {
        assertThat(LotteryRank.valueOf(3)).isEqualTo(LotteryRank.THREE);
        assertThat(LotteryRank.valueOf(6)).isEqualTo(LotteryRank.SIX);
    }

}
