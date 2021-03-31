package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void matchRankTest() {
        assertThat(Rank.matchRank(0, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.matchRank(1, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.matchRank(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.matchRank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.matchRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.matchRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.matchRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.matchRank(6, false)).isEqualTo(Rank.FIRST);
    }

}
