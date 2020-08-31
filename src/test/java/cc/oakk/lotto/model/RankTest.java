package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void getRankByMatchingCount() {
        assertThat(Rank.getRankByDifferentCount(1, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRankByDifferentCount(1, false)).isEqualTo(Rank.THIRD);

        assertThat(Rank.getRankByDifferentCount(0, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRankByDifferentCount(2, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRankByDifferentCount(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRankByDifferentCount(4, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRankByDifferentCount(5, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRankByDifferentCount(6, true)).isEqualTo(Rank.NONE);

        assertThat(Rank.getRankByDifferentCount(0, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRankByDifferentCount(2, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRankByDifferentCount(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRankByDifferentCount(4, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRankByDifferentCount(5, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRankByDifferentCount(6, false)).isEqualTo(Rank.NONE);
    }
}
