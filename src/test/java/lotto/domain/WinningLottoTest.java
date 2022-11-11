package lotto.domain;

import lotto.strategy.ManualNumberStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private static WinningLotto winningLotto;

    @BeforeAll
    static void beforeAll() {
        Lotto lotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusBall = LottoNumber.of(7);
        winningLotto = new WinningLotto(lotto, bonusBall);
    }

    @Test
    void matchCont() {
        Lotto userLotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,10"));
        Lotto userLotto2 = new Lotto(new ManualNumberStrategy("1,2,3,4,5,7"));
        assertThat(winningLotto.matchCount(userLotto.getNumbers())).isEqualTo(5);
        assertThat(winningLotto.matchCount(userLotto2.getNumbers())).isEqualTo(5);
    }

    @Test
    void matchBonus() {
        Lotto userLotto = new Lotto(new ManualNumberStrategy("1,2,3,4,5,10"));
        Lotto userLotto2 = new Lotto(new ManualNumberStrategy("1,2,3,4,5,7"));
        assertThat(winningLotto.matchBonus(userLotto.getNumbers())).isFalse();
        assertThat(winningLotto.matchBonus(userLotto2.getNumbers())).isTrue();
    }
}