package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("5개를 맞추면 3등이다.")
    @Test
    void countOfMatch_five() {
        Rank rank = Rank.valueOf(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("5개를 맞추고 보너스 번호도 맞추면 2등이다.")
    @Test
    void countOfMatch_fiveAndBonus() {
        Rank rank = Rank.valueOf(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("6개를 맞추면 1등이다.")
    @Test
    void countOfMatch_first() {
        Rank rank = Rank.valueOf(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("4개를 맞추면 4등이다.")
    @Test
    void countOfMatch_fourth() {
        Rank rank = Rank.valueOf(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
}