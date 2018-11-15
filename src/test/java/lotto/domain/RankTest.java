package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void MISS() {
        final Rank rank = Rank.valueOf(0, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    public void FIFTH() {
        final Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void FOURTH() {
        final Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void THIRD() {
        final Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    public void SECOND() {
        final Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    public void FIRST() {
        final Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

}