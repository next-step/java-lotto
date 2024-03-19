package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private WinningLotto create(Lotto winningNumberLotto, int bonusNumber) {
        return new WinningLotto(winningNumberLotto, new LottoNumber(bonusNumber));
    }

    @Test
    void 당첨번호나_보너스볼이_널인경우_예외반환한다() {
        assertThatThrownBy(() -> new WinningLotto(null, new LottoNumber(7)))
                .isInstanceOf(InvalidLottoException.class);

        assertThatThrownBy(() -> new WinningLotto(LottoFactory.create(1, 2, 3, 4, 5, 6), null))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 당첨번호와_보너스번호가_중복될경우_예외를반환한다() {
        assertThatThrownBy(() -> create(LottoFactory.create(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 당첨번호와_로또번호_비교하여_일치하는_개수를_반환한다() {
        WinningLotto winningLotto = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = LottoFactory.create(1, 2, 3, 4, 5, 6);

        int actual = winningLotto.compareWith(lotto);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 꽝인경우_0을_반환한다() {
        WinningLotto winningLotto = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = LottoFactory.create(7, 8, 9, 10, 11, 12);

        int actual = winningLotto.compareWith(userLotto);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 보너스볼_포함여부를_확인한다() {
        WinningLotto winningLotto = create(LottoFactory.create(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = LottoFactory.create(7, 8, 9, 10, 11, 12);

        assertThat(winningLotto.containsBonusNumberIn(userLotto)).isTrue();
    }
}
