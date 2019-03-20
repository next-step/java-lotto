package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void check_rank_from_match_count() {
        assertThat(Rank.calculate(3)).isEqualTo(Rank.Fourth);
        assertThat(Rank.calculate(4)).isEqualTo(Rank.Third);
    }

    @Test
    public void display_prize_money_and_real_prize_money() {
        assertThat(Rank.Fourth.getPrizeMoneyForDisplay()).isEqualTo("5,000");
        assertThat(Rank.Fourth.getPrizeMoney()).isEqualTo(5000L);
    }
}
