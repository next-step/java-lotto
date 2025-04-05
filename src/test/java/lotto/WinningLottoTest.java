package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("1등 로또 테스트")
    void firstWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber(7));
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(winningLotto.getRank(lotto)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등 로또 테스트")
    void secondWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber(7));
        Lotto lotto = new Lotto("1,2,3,4,5,7");
        assertThat(winningLotto.getRank(lotto)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("3등 로또 테스트")
    void thirdWinningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber(7));
        Lotto lotto = new Lotto("1,2,3,4,5,8");
        assertThat(winningLotto.getRank(lotto)).isEqualTo(LottoRank.THIRD);
    }

}
