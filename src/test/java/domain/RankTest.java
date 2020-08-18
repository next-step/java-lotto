package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6, false)).isEqualByComparingTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualByComparingTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualByComparingTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualByComparingTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualByComparingTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualByComparingTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualByComparingTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualByComparingTo(Rank.MISS);
    }
}
