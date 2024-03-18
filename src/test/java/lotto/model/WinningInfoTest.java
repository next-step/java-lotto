package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningInfoTest {

    private WinningInfo create(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningInfo(winningNumberLotto, new LottoNumber(bonusNumber));
    }

    @Test
    void 당첨번호와_보너스번호가_중복될경우_예외를반환한다() {
        assertThatThrownBy(() -> create(LottoFactory.create(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하면_2등에_당첨된다() {
        WinningInfo winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(1, 2, 3, 4, 5, 7);
        Rank rank = winningInfo.findRank(userLotto);

        assertThat(rank).isEqualTo(Rank.TWO);
    }

    @Test
    void 당첨번호를_다섯개_맞추고_보너스볼을_포함하지않으면_3등에_당첨된다() {
        WinningInfo winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(1, 2, 3, 4, 5, 8);
        Rank rank = winningInfo.findRank(userLotto);

        assertThat(rank).isEqualTo(Rank.THREE);
    }

    @Test
    void 꽝인경우_NO_MATCH를_반환한다() {
        WinningInfo winningInfo = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);

        Lotto userLotto = LottoFactory.create(9, 10, 11, 12, 13, 14);
        Rank rank = winningInfo.findRank(userLotto);

        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}
