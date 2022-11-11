package lotto.domain;

import lotto.strategy.ManualNumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private static WinningLotto winningLotto;

    @BeforeAll
    static void beforeAll() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,6"));
        winningLotto = new WinningLotto(lotto, LottoNumber.of("7"));
    }

    @Test
    void size() {
        assertThat(new Lotto(new RandomNumberStrategy()).getNumbers()).hasSize(6);
        assertThat(new Lotto(new ManualNumberStrategy("1,2,3,4,5,6")).getNumbers()).hasSize(6);
    }

    @Test
    void 범위() {
        Lotto lotto = new Lotto(new RandomNumberStrategy());
        for (LottoNumber lottoNumber : lotto.getNumbers()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(LottoNumber.of(45));
        }
    }

    @Test
    void 꽝_5등() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,42,43,44,45"));
        Lotto lotto2 = new Lotto(new ManualNumberStrategy("1,2,3,43,44,45"));

        assertThat(lotto.matchWinningLotto(winningLotto)).isEqualTo(WinningType.NOT_WINNING);
        assertThat(lotto2.matchWinningLotto(winningLotto)).isEqualTo(WinningType.FIVE_PLACE);
    }

    @Test
    void 당첨_2등_3등() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,10"));
        Lotto lotto2 = new Lotto(new ManualNumberStrategy("1,2,3,4,5,7"));

        assertThat(lotto.matchWinningLotto(winningLotto)).isEqualTo(WinningType.THIRD_PLACE);
        assertThat(lotto2.matchWinningLotto(winningLotto)).isEqualTo(WinningType.SECOND_PLACE);
    }
}
