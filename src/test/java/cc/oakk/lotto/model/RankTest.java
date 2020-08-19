package cc.oakk.lotto.model;

import cc.oakk.lotto.model.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void getRankByMatchingCount() {
        assertThat(Rank.getRankByDifferentCount(0)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRankByDifferentCount(1)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRankByDifferentCount(2)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRankByDifferentCount(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRankByDifferentCount(4)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRankByDifferentCount(5)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRankByDifferentCount(6)).isEqualTo(Rank.NONE);
    }
}
