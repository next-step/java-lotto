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

        Assertions.assertThatThrownBy(() -> LottoCompany.announce(winNumber))
                .isInstanceOf(NumberFormatException.class);
    }

}
