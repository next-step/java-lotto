package autoLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @DisplayName("로또 번호가 6개이면 검증 성공")
    @Test
    void valid() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1,2,3,4,5,6));
        assertDoesNotThrow(() -> winningLotto.validate());
    }

    @DisplayName("로또 번호가 6개가 아니면 검증 실패")
    @Test
    void invalid() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1,2,3,4,5));
        assertThrows(IllegalArgumentException.class, () -> winningLotto.validate());
    }
}
