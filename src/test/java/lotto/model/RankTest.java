package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void ranks() {
        assertThat(Rank.ranks())
                .containsExactly(Rank.FIVE, Rank.FOUR, Rank.THREE, Rank.TWO, Rank.ONE)
                .isNotIn(Rank.NO_MATCH);
    }

    @Test
    void findRank() {
        assertThat(Rank.findRank(6, false))
                .isEqualTo(Rank.ONE);
        assertThat(Rank.findRank(2, false))
                .isEqualTo(Rank.NO_MATCH);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하면_2등에_당첨된다() {
        Rank rank = Rank.findRank(5, true);

        assertThat(rank).isEqualTo(Rank.TWO);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하지않으면_3등에_당첨된다() {
        Rank rank = Rank.findRank(5, false);

        assertThat(rank).isEqualTo(Rank.THREE);
    }

    @Test
    void 꽝인경우_NO_MATCH를_반환한다() {
        Rank rank = Rank.findRank(0, false);

        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}
