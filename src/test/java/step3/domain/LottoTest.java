package step3.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 같은_숫자_갯수() {
        Lotto lotto1 = Lotto.of(1,2,3,4,5,6);
        Lotto lotto2 = Lotto.of(1,2,3,4,5,7);

        assertThat(lotto1.getMatchCount(lotto2)).isEqualTo(5);
    }

    @Test
    void 로또는_보너스숫자를_포함하는지_판단함() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        LottoNum bonusNum1 = new LottoNum(1);
        LottoNum bonusNum7 = new LottoNum(7);

        assertThat(lotto.containsBonus(bonusNum1)).isTrue();
        assertThat(lotto.containsBonus(bonusNum7)).isFalse();
    }

    @Test
    void 로또는_당첨로또를_받아서_로또결과를_만들어낸다() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), new LottoNum(7));

        assertThat(lotto.getRank(winningLotto)).isEqualTo(Rank.FIRST);
    }
}
