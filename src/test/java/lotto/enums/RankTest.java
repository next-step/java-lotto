package lotto.enums;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void isMiss() {
        assertThat(Rank.FIRST.isMiss()).isEqualTo(false);
        assertThat(Rank.MISS.isMiss()).isEqualTo(true);
    }

    @Test
    public void valueOf() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void equals() {
        assertThat(Rank.FIFTH.equals(Rank.SECOND)).isEqualTo(false);
        assertThat(Rank.FIRST.equals(Rank.FIRST)).isEqualTo(true);
    }
}