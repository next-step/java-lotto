package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private WinningLotto create(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningLotto(winningNumberLotto, new LottoNumber(bonusNumber));
    }

    @Test
    void ranks() {
        assertThat(Rank.ranks())
                .containsExactly(Rank.FIVE, Rank.FOUR, Rank.THREE, Rank.TWO, Rank.ONE)
                .isNotIn(Rank.NO_MATCH);
    }

    @Test
    void find() {
        assertThat(Rank.find(6))
                .isEqualTo(Rank.ONE);
        assertThat(Rank.find(2))
                .isEqualTo(Rank.NO_MATCH);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하면_2등에_당첨된다() {
        WinningLotto winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(1, 2, 3, 4, 5, 7);
        Rank rank = Rank.findUserRank(userLotto, winningInfo);

        assertThat(rank).isEqualTo(Rank.TWO);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하지않으면_3등에_당첨된다() {
        WinningLotto winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(1, 2, 3, 4, 5, 8);
        Rank rank = Rank.findUserRank(userLotto, winningInfo);

        assertThat(rank).isEqualTo(Rank.THREE);
    }

    @Test
    void 꽝인경우_NO_MATCH를_반환한다() {
        WinningLotto winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(9, 10, 11, 12, 13, 14);
        Rank rank = Rank.findUserRank(userLotto, winningInfo);

        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}
