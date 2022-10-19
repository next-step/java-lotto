package lottery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.getRank(LotteryRank.THREE)).isEqualTo(3);
        assertThat(LotteryRank.getRank(LotteryRank.SIX)).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.getPrize(LotteryRank.THREE)).isEqualTo(5000);
        assertThat(LotteryRank.getPrize(LotteryRank.SIX)).isEqualTo(2000000000);
    }

    @Test
    void getUsedRanks() {
        assertThat(LotteryRank.getUsedRanks()).containsExactly(3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:true", "6:true", "7:false"}, delimiter = ':')
    void isUsedRank(int rank, boolean expected) {
        assertThat(LotteryRank.isUsedRank(rank)).isEqualTo(expected);
    }

    @Test
    void getPrizeOfRank() {
        assertThat(LotteryRank.getPrizeOfRank(3)).isEqualTo(LotteryRank.getPrize(LotteryRank.THREE));
        assertThat(LotteryRank.getPrizeOfRank(6)).isEqualTo(LotteryRank.getPrize(LotteryRank.SIX));
    }

    @Test
    void valueOf() {
        assertThat(LotteryRank.valueOf(3)).isEqualTo(LotteryRank.THREE);
        assertThat(LotteryRank.valueOf(6)).isEqualTo(LotteryRank.SIX);
    }

}
