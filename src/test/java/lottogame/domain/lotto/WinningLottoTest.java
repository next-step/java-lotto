package lottogame.domain.lotto;

import lottogame.domain.strategy.PredefinedLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {

    @DisplayName("당첨 로또 번호를 생성한다.")
    @Test
    void create() {
        Lotto winningLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningLotto actual = new WinningLotto(winningLotto, bonusNumber);

        assertEquals(winningLotto, actual.getWinningLotto());
        assertEquals(bonusNumber, actual.getBonusNumber());
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void throwExceptionForDuplicationNumber() {
        Lotto winningLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(winningLotto, bonusNumber);
        });
    }

}
