package lotto;

import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @DisplayName("로또 번호가 6개이면 검증 성공")
    @Test
    void validLotto() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertDoesNotThrow(() -> winningLotto.validate());
    }

    @DisplayName("로또 번호가 6개가 아니면 검증 실패")
    @Test
    void invalidLotto() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5", "7");
        assertThrows(IllegalArgumentException.class, () -> winningLotto.validate());
    }

    @DisplayName("로또 번호의 원소와 보너스 번호가 일치하면 검증 실패")
    @Test
    void invalidBonusNumber() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "1");
        assertThrows(IllegalArgumentException.class, () -> winningLotto.validate());
    }

    @DisplayName("로또 번호의 원소와 보너스 번호가 일치하지 않으면 검증 실패")
    @Test
    void validBonusNumber() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertDoesNotThrow(() -> winningLotto.validate());
    }
}
