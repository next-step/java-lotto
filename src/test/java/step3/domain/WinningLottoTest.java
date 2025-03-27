package step3.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void 당첨로또는_당첨로또숫자와_보너스숫자를_가진다() {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), new LottoNum(7));
        assertThat(winningLotto.getWinningLotto()).isEqualTo(Lotto.of(1,2,3,4,5,6));
        assertThat(winningLotto.getBonusNum()).isEqualTo(new LottoNum(7));
    }

}
