package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 일치개수_6개는_1등이다() {
        Rank rank = Rank.valueOf(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getWinningAmount()).isEqualTo(2_000_000_000);
    }

    @Test
    void 일치개수_5이고_보너스가_일치하면_2등이다() {
        Rank rank = Rank.valueOf(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getWinningAmount()).isEqualTo(30_000_000);
    }

    @Test
    void 일치개수_5개는_3등이다() {
        Rank rank = Rank.valueOf(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getWinningAmount()).isEqualTo(1_500_000);
    }

    @Test
    void 일치개수_4개는_4등이다() {
        Rank rank = Rank.valueOf(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getWinningAmount()).isEqualTo(50_000);
    }

    @Test
    void 일치개수_3개는_5등이다() {
        Rank rank = Rank.valueOf(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getWinningAmount()).isEqualTo(5_000);
    }


    @Test
    void 일치개수_2개_이하는_낙첨이며_상금은_0원이다() {
        Rank rank = Rank.valueOf(2, false);

        assertThat(rank).isEqualTo(Rank.MISS);
        assertThat(rank.getWinningAmount()).isEqualTo(0);
    }
}
