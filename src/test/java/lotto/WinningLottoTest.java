package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다")
    void duplicatedLottoNumbersAndBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.valueOf(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호와 보너스 번호가 중복되었습니다.");
    }
}
