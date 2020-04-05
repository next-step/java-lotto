package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void valueOf() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(2)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1)).isEqualTo(Rank.MISS);
    }
}
