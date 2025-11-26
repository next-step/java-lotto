package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {
    @Test
    @DisplayName("로또 당첨 번호가 보너스볼의 번호를 포함하면 예외가 발생한다.")
    void createWrongWinningLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(1)));
    }

    @Test
    @DisplayName("로또의 당첨 순위 1등을 계산해 반환한다.")
    void calculateFirstPrize() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(45));
        assertThat(winningLotto.calculatePrize(lotto)).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("로또의 당첨 순위 2등을 계산해 반환한다.")
    void calculateSecondPrize() {
        Lotto lotto = new Lotto(2, 3, 4, 5, 6, 45);
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(45));
        assertThat(winningLotto.calculatePrize(lotto)).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("로또 당첨 실패를 계산해 반환한다.")
    void calculateMissPrize() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(38, 39, 40, 41, 42, 43), new LottoNumber(45));
        assertThat(winningLotto.calculatePrize(lotto)).isEqualTo(Prize.MISS);
    }
}