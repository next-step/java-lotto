package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 일치개수_6개는_1등이며_상금은_20억이다() {
        Rank rank = Rank.valueOf(6);

        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getWinningAmount()).isEqualTo(2_000_000_000);
    }

    @Test
    void 일치개수_5개는_2등이며_상금은_150만이다() {
        Rank rank = Rank.valueOf(5);

        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getWinningAmount()).isEqualTo(1_500_000);
    }

    @Test
    void 일치개수_4개는_3등이며_상금은_5만이다() {
        Rank rank = Rank.valueOf(4);

        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getWinningAmount()).isEqualTo(50_000);
    }

    @Test
    void 일치개수_3개는_4등이며_상금은_5천이다() {
        Rank rank = Rank.valueOf(3);

        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getWinningAmount()).isEqualTo(5_000);
    }

    @Test
    void 일치개수_2개_이하는_낙첨이며_상금은_0원이다() {
        Rank rank = Rank.valueOf(2);

        assertThat(rank).isEqualTo(Rank.MISS);
        assertThat(rank.getWinningAmount()).isEqualTo(0);
    }
}
