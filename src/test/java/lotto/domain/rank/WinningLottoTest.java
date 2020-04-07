package lotto.domain.rank;

import lotto.common.LottoStub;
import lotto.domain.lotto.BonusNumberDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호는 6개의 로또 넘버와 1개의 보너스 번호를 가진다")
    @Test
    public void newWinningTicket() {
        WinningLotto winningLotto = new WinningLotto(
                LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("보너스 넘버는 당첨 번호는 6개와 중복되어서는 안된다")
    @Test
    public void bonusNumberDuplicateTest() {
        assertThatThrownBy(() -> new WinningLotto(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(BonusNumberDuplicateException.class)
                .hasMessageContaining("보너스 번호는 당첨번호와 중복될 수 없습니다.");

    }

    @DisplayName("두 당첨번호의 로또 번호와 보너스 번호가 일치하면 두 당첨 번호는 같은 당첨번호이다")
    @Test
    public void twoWinningNumbersEqualsTest() {
        WinningLotto winningLotto = new WinningLotto(
                LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);
        WinningLotto otherWinningLotto = new WinningLotto(
                LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto).isEqualTo(otherWinningLotto);
    }
}
