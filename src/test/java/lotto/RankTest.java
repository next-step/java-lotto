package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void rankGetValueTest() {
        Rank[] ranks = Rank.values();
        assertThat(ranks).hasSize(6);
        assertThat(ranks).contains(Rank.MISS);
        assertThat(ranks[0].getCountOfMatch()).isEqualTo(6);
    }

    @Test
    void matchRankValueTest() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void matchBonusTest() {
        assertThat(Rank.validateBonus(true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.validateBonus(false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }
}
