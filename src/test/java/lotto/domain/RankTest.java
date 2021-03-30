package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    public static final Long THREE_PRICE = 5000L;
    public static final Long FOUR_PRICE = 50_000L;
    public static final Long FIVE_PRICE = 1_500_000L;
    public static final Long SIX_PRICE = 2_000_000_000L;

    @Test
    void matchRankTest() {
        assertThat(Rank.matchRank(0).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(1).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(2).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(3).getWinningMoney()).isEqualTo(THREE_PRICE);
        assertThat(Rank.matchRank(4).getWinningMoney()).isEqualTo(FOUR_PRICE);
        assertThat(Rank.matchRank(5).getWinningMoney()).isEqualTo(FIVE_PRICE);
        assertThat(Rank.matchRank(6).getWinningMoney()).isEqualTo(SIX_PRICE);
    }

}
