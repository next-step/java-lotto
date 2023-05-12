package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void findRank() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);

        Rank rank = winningLotto.findRank(lotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

}