package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 숫자가 이미 당첨번호로 나온 숫자이면 예외가 발생한다")
    void duplicate_exception_test() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, new LottoNumber(1)));
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, new LottoNumber(2)));
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(lotto, new LottoNumber(3)));
        assertDoesNotThrow(() -> new WinningLotto(lotto, new LottoNumber(7)));
    }

}
