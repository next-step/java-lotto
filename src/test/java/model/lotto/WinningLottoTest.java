package model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningLottoTest {
    @Test
    @DisplayName("보너스 숫자와 로또 번호는 중복이 있으면 안된다.")
    public void checkValidBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 6", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또에 보너스 숫자가 존재한다.")
    public void containsBonusNumber() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);
        assertTrue(winningLotto.containsWinBonusNumber(new LottoNumber(7)));
    }

    @Test
    @DisplayName("구매한 로또에 보너스 숫자가 존재하지 않는다.")
    public void containsBonusNumberFail() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);
        assertFalse(winningLotto.containsWinBonusNumber(new LottoNumber(8)));
    }
}