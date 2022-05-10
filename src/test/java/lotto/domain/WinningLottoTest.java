package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 안된다.")
    @Test
    void createWinningNumbersTest() {
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.createNewNumber(3);
        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}