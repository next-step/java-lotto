package lotto.domain;

import lotto.domain.lotto.LottoCompany;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoCompanyTest {

    @DisplayName("로또 당첨 번호는 숫자 형태여야 한다.")
    @Test
    public void pickWinNumber_NumberMustBeNumeric_IfNotThrowException() {
        String winNumber = "1, 2, 3, 4, a, 5";
        String bonusWinNumber = "7";

        Assertions.assertThatThrownBy(() -> LottoCompany.getInstance().announce(winNumber, bonusWinNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호가 로또 번호들과 중복되면 예외를 던진다.")
    @Test
    public void pickWinNumber_BonusDuplicate_ThrowException() {
        String winNumber = "1, 2, 3, 4, 5, 6";
        String bonusWinNumber = "1";

        Assertions.assertThatThrownBy(() -> LottoCompany.getInstance().announce(winNumber, bonusWinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동번호를 입력받아 갯수만큼 수동로또를 생성한다.")
    @Test
    public void makeManualBundle_InputManualNumbers_MakeSuccess() {
        List<String> answerStrings = Arrays.asList("1, 2, 3, 4, 5, 6"
                                                    , "2, 3, 4, 5, 6, 7"
                                                    , "3, 4, 5, 6, 7, 8");

        Assertions.assertThat(LottoCompany.getInstance().makeManualBundle(answerStrings)
                .unfoldLottoBundle().size()).isEqualTo(3);
    }

}
