package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryRankTest {

    @Test
    void getRank() {
        assertThat(LotteryRank.FOURTH.getMatchingCount()).isEqualTo(3);
        assertThat(LotteryRank.FIRST.getMatchingCount()).isEqualTo(6);
    }

    @Test
    void getPrize() {
        assertThat(LotteryRank.FOURTH.getPrize()).isEqualTo(5000);
        assertThat(LotteryRank.FIRST.getPrize()).isEqualTo(2000000000);
    }

    @Test
    void valueOf() {
        assertThat(LotteryRank.valueOf(3)).isEqualTo(LotteryRank.FOURTH);
        assertThat(LotteryRank.valueOf(6)).isEqualTo(LotteryRank.FIRST);
    }

}
