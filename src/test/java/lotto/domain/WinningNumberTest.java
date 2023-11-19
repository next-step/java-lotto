package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumberTest {

    @Test
    void create() {
        WinningNumber winningNumber = new WinningNumber(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7));
        assertThat(winningNumber).isEqualTo(new WinningNumber(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7)));
    }

    @DisplayName("로또 당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void 로또번호와_보너스번호_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumber(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(6));
        });
    }
}