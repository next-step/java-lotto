package lotto.domain;

import lotto.strategy.ManualNumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void size() {
        assertThat(new Lotto(new RandomNumberStrategy()).getNumbers()).hasSize(6);
        assertThat(new Lotto(new ManualNumberStrategy("1,2,3,4,5,6")).getNumbers()).hasSize(6);
    }

    @Test
    void 범위() {
        Lotto lotto = new Lotto(new RandomNumberStrategy());
        for (LottoNumber lottoNumber : lotto.getNumbers()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(new LottoNumber(45));
        }
    }

    @Test
    void 꽝_5등() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,42,43,44,45"));
        Lotto lotto2 = new Lotto(new ManualNumberStrategy("1,2,3,43,44,45"));
        Lotto winningLotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,6"));
        BonusBall bonusBall = new BonusBall("7", winningLotto);

        assertThat(lotto.matchWinningLotto(winningLotto, bonusBall)).isEqualTo(WinningType.NOT_WINNING);
        assertThat(lotto2.matchWinningLotto(winningLotto, bonusBall)).isEqualTo(WinningType.FIVE_PLACE);
    }

    @Test
    void 당첨_2등_3등() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,10"));
        Lotto lotto2 = new Lotto(new ManualNumberStrategy("1,2,3,4,5,7"));
        Lotto winningLotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,6"));
        BonusBall bonusBall = new BonusBall("7", winningLotto);

        assertThat(lotto.matchWinningLotto(winningLotto, bonusBall)).isEqualTo(WinningType.THIRD_PLACE);
        assertThat(lotto2.matchWinningLotto(winningLotto, bonusBall)).isEqualTo(WinningType.SECOND_PLACE);
    }
}
