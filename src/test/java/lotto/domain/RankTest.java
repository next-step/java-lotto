package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 일치개수_6개는_1등이다() {
        Rank rank = Rank.valueOf(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 일치개수_5이고_보너스가_일치하면_2등이다() {
        Rank rank = Rank.valueOf(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 일치개수_5개는_3등이다() {
        Rank rank = Rank.valueOf(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 일치개수_4개는_4등이다() {
        Rank rank = Rank.valueOf(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치개수_3개는_5등이다() {
        Rank rank = Rank.valueOf(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }


    @Test
    void 일치개수_2개_이하는_낙첨이다() {
        Rank rank = Rank.valueOf(2, false);

        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
