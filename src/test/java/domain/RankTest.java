package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void check_rank_from_match_count() {
        assertThat(Rank.calculate(3, false)).isEqualTo(Rank.Fifth);
        assertThat(Rank.calculate(4, false)).isEqualTo(Rank.Fourth);
    }

    @Test
    public void second_rank_if_bonus_has() {
        assertThat(Rank.calculate(5, true)).isEqualTo(Rank.Second);
        assertThat(Rank.calculate(5, false)).isEqualTo(Rank.Third);
    }
}
