package lotto.domain.rank;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankCountsTest {
    @Test
    void increaseCount() {
        // given
        final RankCounts rankCounts = RankCounts.of();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // then
        assertThat(rankCounts.increaseCount(hitThreeTimes, true)).isEqualTo(1);
        assertThat(rankCounts.increaseCount(hitThreeTimes, true)).isEqualTo(2);
        assertThat(rankCounts.increaseCount(hitThreeTimes, true)).isEqualTo(3);
    }

    @Test
    void getCount() {
        // given
        final RankCounts rankCounts = RankCounts.of();
        final int hitThreeTimes = Rank.FOURTH.getCountOfMatch();

        // when
        rankCounts.increaseCount(hitThreeTimes, true);

        // then
        assertAll(
                () -> AssertionsForClassTypes.assertThat(rankCounts.getCount(Rank.FOURTH)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(rankCounts.getCount(Rank.THIRD)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(rankCounts.getCount(Rank.SECOND)).isEqualTo(0),
                () -> AssertionsForClassTypes.assertThat(rankCounts.getCount(Rank.FIRST)).isEqualTo(0)
        );
    }

    @Test
    void getCount_return_0() {
        // given
        final RankCounts rankCounts = RankCounts.of();
        final Rank nullRank = null;

        // when
        final int result = rankCounts.getCount(nullRank);

        // then
        assertThat(result).isZero();
    }
}