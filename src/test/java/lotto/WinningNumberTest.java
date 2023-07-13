package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.domain.game.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("보너스볼이 로또안에 있으면 예외가 발생한다")
    @Test
    void 로또_보너스볼_포함 () {
        String lottoValue = "1,2,3,4,5,6";
        String bonusValue = "1";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumber(lottoValue, bonusValue))
            .withMessage("보너스볼이 당첨번호에 존재합니다");
    }

    @DisplayName("보너스볼이 로또안에 없으면 예외가 발생하지 않는다")
    @Test
    void 로또_보너스볼_불포함 () {
        String lottoValue = "1,2,3,4,5,6";
        String bonusValue = "7";

        assertThatNoException().isThrownBy(() -> new WinningNumber(lottoValue, bonusValue));
    }

}
