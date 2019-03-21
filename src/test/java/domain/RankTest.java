package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void check_rank_from_match_count() {
        assertThat(Rank.calculate(3)).isEqualTo(Rank.Fourth);
        assertThat(Rank.calculate(4)).isEqualTo(Rank.Third);
    }

}
