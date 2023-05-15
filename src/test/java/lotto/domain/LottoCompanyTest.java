package lotto.domain;

import lotto.domian.LottoCompany;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCompanyTest {

    @DisplayName("로또 당첨 번호는 숫자 형태여야 한다.")
    @Test
    public void pickWinNumber_NumberMustBeNumeric_IfNotThrowException() {
        String winNumber = "1, 2, 3, 4, a, 5";
        String bonusWinNumber = "7";

        Assertions.assertThatThrownBy(() -> LottoCompany.announce(winNumber, bonusWinNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호가 로또 번호들과 중복되면 예외를 던진다.")
    @Test
    public void pickWinNumber_BonusDuplicate_ThrowException() {
        String winNumber = "1, 2, 3, 4, 5, 6";
        String bonusWinNumber = "1";

        Assertions.assertThatThrownBy(() -> LottoCompany.announce(winNumber, bonusWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
